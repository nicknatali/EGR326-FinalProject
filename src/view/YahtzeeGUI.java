package view;


import com.sun.tools.javac.comp.Lower;
import model.Player;
import model.YahtzeeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class YahtzeeGUI{
    /*
     Variables for game logic
     */
    YahtzeeGame game;
    String[] playerValues = {"Human", "Four & Up", "One-of-a-Kind", "Random", "Smart", "Upper-Sectioner"};

    /*
     Constant variables for GUI panel
     */
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 700;
    /*
     Swing variables for GUI panel
     */
    private JFrame frame;
    private View view;
    //Dice panel
    JTextField player1NameEntry;
    JComboBox<String> player1List = new JComboBox<String>(playerValues);
    JLabel player1WinsLabel;
    JLabel player1LossesLabel;
    //Swing Variables for Player 2
    JTextField player2NameEntry;
    JComboBox<String> player2List = new JComboBox<String>(playerValues);
    JLabel player2WinsLabel;
    JLabel player2LossesLabel;
    //Swing variables for lower panel
    JButton newGameButton;
    JButton resetButton;
    JButton exitButton;
    //Variable for label
    JLabel currMessage = new JLabel("Hit new game to start a new game!");


    /*
    Variables for GUI panel
    */
    public YahtzeeGUI(YahtzeeGame thisGame){
        this.game = thisGame;
        //Add frame settings
        frame = new JFrame ("Yahtzee");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        //Center window in the middle of the screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenshot = toolkit.getScreenSize();
        frame.setLocation((screenshot.width - WIDTH)/2, (screenshot.height - HEIGHT)/2);
        //Set up players panel
        setupPlayerPanel();
        //Create initial view
        view = new ComponentView(game);
        frame.getContentPane().add(view);
        //Add lower panel
        setupLowerPanel();
        //Add handle events
        handleEvents();
        //Pack frame
        frame.pack();
        //Display GUI
        frame.setVisible(true);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }


    public void setupPlayerPanel(){
        /*
            Create Container for Player Panels
         */
        JPanel playerPanelContainer = new JPanel();
        playerPanelContainer.setLayout(new GridLayout(1,2));

        /*
            Create Panel for Player 1
         */
        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));
        //Swing Variables for Player 1
        player1NameEntry = new JTextField(game.getPlayers()[0].getName());
        player1WinsLabel = new JLabel("Wins: " + game.getPlayers()[0].getWins());
        player1LossesLabel = new JLabel("Losses: " + game.getPlayers()[0].getLosses());
        //Adds the objects to the player 1 panel
        player1Panel.add(player1NameEntry);
        player1Panel.add(player1List);
        player1Panel.add(player1WinsLabel);
        player1Panel.add(player1LossesLabel);
        player1Panel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        player1Panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 30, 10, 10), new EtchedBorder()));

        /*
            Create Panel for Player 2
         */
        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));
        //Swing Variables for Player 2
        player2NameEntry = new JTextField(game.getPlayers()[1].getName());
        player2WinsLabel = new JLabel("Wins: " + game.getPlayers()[1].getWins());
        player2LossesLabel = new JLabel("Losses: " + game.getPlayers()[1].getLosses());
        //Adds the objects to the player 2 panel
        player2Panel.add(player2NameEntry);
        player2Panel.add(player2List);
        player2Panel.add(player2WinsLabel);
        player2Panel.add(player2LossesLabel);
        player2Panel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        player2Panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 30), new EtchedBorder()));
        //Add the two panels to the container
        playerPanelContainer.add(player1Panel);
        playerPanelContainer.add(player2Panel);

        /*
            Create Panel for Player 2
         */
        frame.add(playerPanelContainer, BorderLayout.NORTH);
        frame.pack();
    }



    public void setupLowerPanel(){
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout (2, 1));
        //Create a new panel for the button menu
        JPanel buttonMenu = new JPanel();
        buttonMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Setup lower panel buttons
        newGameButton = new JButton("New Game");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
        //Add all buttons to panel
        buttonMenu.add(newGameButton);
        buttonMenu.add(resetButton);
        buttonMenu.add(exitButton);
        //Add border for buttom menu
        buttonMenu.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        buttonMenu.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
        //Add button menu to the panel
        lowerPanel.add(buttonMenu);
        //Create a panel for messages
        JPanel messageBox = new JPanel();
        messageBox.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Add the current message to the message box
        messageBox.add(currMessage);
        //Add a border to the message box
        messageBox.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        messageBox.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), new EtchedBorder()));
        //Add the messageBox to the panel
        lowerPanel.add(messageBox);
        //Add the panel to the frame and set visible
        frame.add(lowerPanel, BorderLayout.SOUTH);
    }

    // attaches various listeners to handle events
    private void handleEvents() {
        exitButton.addActionListener(e -> { System.exit(0); });
        newGameButton.addActionListener(new NewGameAction());
    }


    // This class handles "action events", aka mouse clicks, in buttons.
    public class NewGameAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            game.setStarted(true);
            game.resetGame();
            game.setDiceRollState(true);
            game.rollDice();
            view.update(null, null);
            updateMessage();
        }
    }


    public void updateMessage(){
        //Update names
        game.getPlayers()[0].setName(player1NameEntry.getText());
        game.getPlayers()[1].setName(player2NameEntry.getText());
        //Display correct message
        if(game.isGameOver()){
            int p1Score = game.getPlayers()[0].calculateScore();
            int p2Score = game.getPlayers()[1].calculateScore();
            //Construct the new message
            StringBuilder message = new StringBuilder(game.getPlayers()[0].getName() + " scored: " + p1Score +
                    " and " + game.getPlayers()[1].getName() + " scored: " + p2Score + "! ");
            //Get current winner
            Player winner = game.declareWinner();
            //Modify and set text based on winner
            message.append(winner == null ? "Its a draw!" : (winner.getName() + " wins!"));
            currMessage.setText(message.toString());
            updateWins();

        } else {
            currMessage.setText("It is " + game.getCurrPlayer().getName() + "'s turn!");
        }
    }


    public void updateWins(){
        player1WinsLabel.setText("Wins: " + game.getPlayers()[0].getWins());
        player1LossesLabel.setText("Losses: " + game.getPlayers()[0].getLosses());
        player2WinsLabel.setText("Wins: " + game.getPlayers()[1].getWins());
        player2LossesLabel.setText("Losses: " + game.getPlayers()[1].getLosses());
    }
}