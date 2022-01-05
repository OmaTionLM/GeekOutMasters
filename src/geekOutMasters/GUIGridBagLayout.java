package geekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jeison Perea -  && Alan Valderrama - alan.valderrama@correounivalle.edu.co
 * @code : 2077250 - 2042836
 * @version: v1.0
 * @fecha: 01/04/2022
 */
public class GUIGridBagLayout extends JFrame
{

    public static final String BEGINNING_MESSAGE="Welcome to Geek Out Masters \n"

            +"Push the button 'Play' to start the game."
            +"\nYou have ten dice, your goal is to make as many dice as possible '42' "
            +"using the powers that have randomly come to you."
            +"\nEach face of the dice will have powers, which are:"
            +"\n42: This dice will add you points."
            +"\nDragon: This dice will take away the points you have obtained in the round."
            +"\nHeart: Allows you to take a dice from the inactive dice section and roll it to make it a new active dice."
            +"\nHero: Allows any unused dice (active dice section) to be flipped over and placed on its opposite side."
            +"\nShip: This dice send an unused dice (from the active dice section) to inactive dice section."
            +"\nMeeple: Allow you to re-roll another dice in play, that is, from the active dice section. \n"
            +"\nWatch out for the dragon!";

    private Header headerProject;
    private JLabel dice1, dice2, dice3, dice4, dice5, dice6, dice7,dice8 ,dice9,dice10;
    private JButton play, help, exit;
    private JPanel inactiveDicePanel, diceUsedPanel, yourDicePanel;
    private ImageIcon diceImage;
    private JTextArea yourScoreMessage;
    private Listener listener;
    private GeekOutMasters geekOutMasters;

    /**
     * Constructor of GUI class
     */
    public GUIGridBagLayout()
    {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        //this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI()
    {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        //Create Listener Object and Control Object
        listener=new Listener();
        geekOutMasters=new GeekOutMasters();

        //Set up JComponents
        /**
         * Header of interface
         */
        headerProject = new Header("Geek Out Master Table", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        /**
         * Button help
         */
        help=new JButton("How to play?");
        help.addActionListener(listener);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(help, constraints);

        /**
         * Exit Button
         */
        exit=new JButton("  Exit  ");
        exit.addActionListener(listener);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(exit, constraints);

        /**
         * Initial image of the dice
         */
        diceImage=new ImageIcon(getClass().getResource("/resources/1.jpg"));
        dice1=new JLabel(diceImage);
        dice2=new JLabel(diceImage);
        dice3=new JLabel(diceImage);
        dice4=new JLabel(diceImage);
        dice5=new JLabel(diceImage);
        dice6=new JLabel(diceImage);
        dice7=new JLabel(diceImage);
        dice8=new JLabel(diceImage);
        dice9=new JLabel(diceImage);
        dice10=new JLabel(diceImage);

        /**
         * Inactive dice panel
         */
        inactiveDicePanel=new JPanel();
        inactiveDicePanel.setPreferredSize(new Dimension(380,300));
        inactiveDicePanel.setBorder(BorderFactory.createTitledBorder("Inactive Dice."));
        inactiveDicePanel.add(dice1);
        inactiveDicePanel.add(dice2);
        inactiveDicePanel.add(dice3);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(inactiveDicePanel, constraints);

        /**
         * Dice used panel
         */
        diceUsedPanel=new JPanel();
        diceUsedPanel.setPreferredSize(new Dimension(600,300));
        diceUsedPanel.setBorder(BorderFactory.createTitledBorder("Dice Used."));
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(diceUsedPanel, constraints);

        /**
         * Your score panel
         */
        yourScoreMessage=new JTextArea();
        yourScoreMessage.setPreferredSize(new Dimension(380,300));
        yourScoreMessage.setBorder(BorderFactory.createTitledBorder("Your Score."));
        yourScoreMessage.setText("Round 1 score: "+geekOutMasters.getRoundPoints()
                                +"\nRound 2 score: "+geekOutMasters.getRoundPoints()
                                +"\nRound 3 score: "+geekOutMasters.getRoundPoints()
                                +"\nRound 4 score: "+geekOutMasters.getRoundPoints()
                                +"\nRound 5 score: "+geekOutMasters.getRoundPoints()
                                +"\n \nTotal points: "+geekOutMasters.getTotalPoints());
        yourScoreMessage.setEditable(false);
        constraints.gridx=2;
        constraints.gridy=2;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(yourScoreMessage, constraints);

        /**
         * Your dice panel
         */
        yourDicePanel=new JPanel();
        yourDicePanel.setPreferredSize(new Dimension(600,300));
        yourDicePanel.setBorder(BorderFactory.createTitledBorder("Your dice."));
        yourDicePanel.add(dice4);
        yourDicePanel.add(dice5);
        yourDicePanel.add(dice6);
        yourDicePanel.add(dice7);
        yourDicePanel.add(dice8);
        yourDicePanel.add(dice9);
        yourDicePanel.add(dice10);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(yourDicePanel, constraints);

        /**
         * Play Button
         */
        play=new JButton("Play");
        play.addActionListener(listener);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(play, constraints);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==play)
            {
                geekOutMasters.determinateFace();
                int[] faces=geekOutMasters.getFaces();
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[0]+".jpg"));
                dice1.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[1]+".jpg"));
                dice2.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[2]+".jpg"));
                dice3.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[3]+".jpg"));
                dice4.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[4]+".jpg"));
                dice5.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[5]+".jpg"));
                dice6.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[6]+".jpg"));
                dice7.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[7]+".jpg"));
                dice8.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[8]+".jpg"));
                dice9.setIcon(diceImage);
                diceImage=new ImageIcon(getClass().getResource("/resources/"+faces[9]+".jpg"));
                dice10.setIcon(diceImage);

            }
            else
            {
                if(e.getSource()==help)
                {
                    JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }
}
