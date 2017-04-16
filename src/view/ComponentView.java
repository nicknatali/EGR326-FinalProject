package view;


import model.Category;
import model.YahtzeeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

public class ComponentView extends View{
    /*
        Swing variables for GUI panel
    */
    private JPanel dicePanel = new JPanel();
    private JPanel p1Panel = new JPanel();
    private JPanel p2Panel = new JPanel();

    private JButton[] diceButtons = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton()};
    private JButton rollButton = new JButton("Roll!");
    private JButton[] p1Categories = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
                                    new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
                                    new JButton(), new JButton(), new JButton()};

    private JButton[] p2Categories = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton()};

    /*
        Constructs component view
    */
    public ComponentView(YahtzeeGame game){
        super(game);
        game.addObserver(this);
        //Set layout for whole view
        this.setLayout(new FlowLayout());
        //Create initial setup
        setState();
        //Add action listener
        handleEvents();

        /*
            Create layout for Dice Panel
         */
        dicePanel.setLayout(new GridLayout(6, 1));
        dicePanel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        dicePanel.setBackground(Color.gray);
        //Add details to roll button
        rollButton.setBackground(Color.GREEN);
        rollButton.setOpaque(true);
        rollButton.setPreferredSize(new Dimension(70, 70));
        //Add roll button to frame
        dicePanel.add(rollButton);
        //Set each button to desired size and add to frame
        for(JButton each : diceButtons){
            each.setPreferredSize(new Dimension(70, 70));
            dicePanel.add(each);
        }

        /*
            Create layout for P1 Panel
         */
        p1Panel.setLayout(new GridLayout(13, 1));
        p1Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        p1Panel.setBackground(Color.gray);
        for(JButton each : p1Categories){
            each.setPreferredSize(new Dimension(175, 32));
            p1Panel.add(each);
        }

        /*
            Create layout for P1 Panel
         */
        p2Panel.setLayout(new GridLayout(13, 1));
        p2Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        p2Panel.setBackground(Color.gray);
        for(JButton each : p2Categories){
            each.setPreferredSize(new Dimension(175, 32));
            p2Panel.add(each);
        }

        /*
            Create layout for P1 Panel
         */
        this.add(dicePanel);
        this.add(p1Panel, BorderLayout.SOUTH);
        this.add(p2Panel, BorderLayout.SOUTH);


    }

    /*
        Updates view
    */
    @Override
    public void update(Observable o, Object arg) {
        setState();
    }


    private void setState(){
        /*
            Set icon for dice depending on state
        */
        for(int i = 0; i < diceButtons.length; i++){
            //Try to set icons for each dice
            try {
                //Create image object
                String path;
                //If dice can be rolled
                if(game.getDice()[i].isRollable() && game.isPlayerAbleToRoll() && game.isStarted())
                    path = "./rsc/d" + game.getDice()[i].getValue() + "-unpressed.png";
                else
                    path = "./rsc/d" + game.getDice()[i].getValue() + "-pressed.png";
                //Set icon for each button
                diceButtons[i].setIcon(new ImageIcon(ImageIO.read(new File(path))));
            } catch (Exception e) {}
        }

        /*
            Set label for categories depending on state
        */
        for(int i = 0; i < p1Categories.length; i++){
            if(game.getPlayers()[0].getScoreCard().getScore(Category.fromInteger(i)) == -1 && game.getCurrPlayer() == game.getPlayers()[0] && game.isStarted()) {
                int score = game.getCurrScores().get(Category.fromInteger(i));
                p1Categories[i].setText(Category.fromInteger(i).toString() + "   " + score);
                p1Categories[i].setEnabled(true);
            } else {
                int score = game.getPlayers()[0].getScoreCard().getScore(Category.fromInteger(i));
                p1Categories[i].setText(Category.fromInteger(i).toString() + "   " + (score == -1 ? "NA" : score));
                p1Categories[i].setEnabled(false);
            }
        }

        /*
            Set label for categories depending on state
        */
        for(int i = 0; i < p2Categories.length; i++){
            if(game.getPlayers()[1].getScoreCard().getScore(Category.fromInteger(i)) == -1 && game.getCurrPlayer() == game.getPlayers()[1]) {
                int score = game.getCurrScores().get(Category.fromInteger(i));
                p2Categories[i].setText(Category.fromInteger(i).toString() + "   " + score);
                p2Categories[i].setEnabled(true);
            } else {
                int score = game.getPlayers()[1].getScoreCard().getScore(Category.fromInteger(i));
                p2Categories[i].setText(Category.fromInteger(i).toString() + "   " + (score == -1 ? "NA" : score));
                p2Categories[i].setEnabled(false);
            }
        }
    }


    // attaches various listeners to handle events
    private void handleEvents() {
        //Add roll button listener
        rollButton.addActionListener(new RollListener());
        //Add listener for dice buttons
        for(int i = 0; i < diceButtons.length; i++) diceButtons[i].addActionListener(new DiceListener(i));
        //Add listener for p1 category buttons
        for(int i = 0; i < p1Categories.length; i++) p1Categories[i].addActionListener(new CategoryListener(i));
        //Add listener for p2 category buttons
        for(int i = 0; i < p2Categories.length; i++) p2Categories[i].addActionListener(new CategoryListener(i));
    }


    // This listener responds to clicks on a dice button.
    private class DiceListener implements ActionListener {
        /**
         * Called when a dice is clicked
         */
        private int diceNum;
        public DiceListener(int diceNum){ this.diceNum = diceNum; }

        public void actionPerformed(ActionEvent e) {
            if(game.isStarted()) {
                game.getDice()[diceNum].setRollable(!game.getDice()[diceNum].isRollable());
                setState();
            }
        }
    }



    // This listener responds to clicks on the roll button.
    private class RollListener implements ActionListener {
        /**
         * Called when roll is clicked
         */
        public void actionPerformed(ActionEvent e) {
            if(game.isStarted()) {
                game.rollDice();
                setState();
            }
        }
    }



    // This listener responds to clicks on the roll button.
    private class CategoryListener implements ActionListener {
        /**
         * Called when a dice is clicked
         */
        private int categoryNum;
        public CategoryListener(int categoryNum){ this.categoryNum = categoryNum; }

        public void actionPerformed(ActionEvent e) {
            Category category = Category.fromInteger(categoryNum);
            game.getCurrPlayer().getScoreCard().setScore(category, game.getCurrScores().get(category));
            game.swapCurrentPlayer();
            game.resetRerolls();
            game.setDiceRollState(true);
            game.rollDice();
            game.getGui().updateMessage();
            setState();
        }
    }
}
