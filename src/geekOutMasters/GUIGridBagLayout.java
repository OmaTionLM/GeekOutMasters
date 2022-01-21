package geekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * @author Jeison Perea -  && Alan Valderrama - alan.valderrama@correounivalle.edu.co
 * @code : 2077250 - 2042836
 * @version: v1.0
 * @fecha: 01/04/2022
 */
public class GUIGridBagLayout extends JFrame
{

    public static final String BEGINNING_MESSAGE="Welcome to Geek Out Masters\n"

            +"Push the button 'Play' to start the game (once you press the button, it will be available in the next round).\n"
            +"\nYou have ten dice, your goal is to make as many dice as possible '42' "
            +"using the powers that have randomly come to you."
            +"\nEach face of the dice will have powers, which are:\n"
            +"\n42: This dice will add you points."
            +"\nDragon: This dice will take away the points you have obtained in the round."
            +"\nHeart: Allows you to take a dice from the inactive dice section and roll it to make it a new active dice."
            +"\nHero: Allows any unused dice (active dice section) to be flipped over and placed on its opposite side."
            +"\nShip: This dice send an unused dice (from the active dice section) to inactive dice section."
            +"\nMeeple: Allow you to re-roll another dice in play, that is, from the active dice section. \n"
            +"\nWatch out for the dragon!";

    /**
     * Private attributes
     */
    private JButton[] dice;
    private JButton play, help, exit;
    private ImageIcon diceImage;
    private GeekOutMasters geekOutMasters;
    private int flagPlay=0, roundCount=0;
    private int[] faces;

    /**
     * Public attributes
     */
    public Header headerProject;
    public JPanel[] panelsToUse;
    public Listener listener;
    public JTextArea yourScoreMessage;

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
         * Panel creation
         */
        panelsToUse=new JPanel[3];

        panelsToUse[0]=new JPanel();//This is the inactive dice panel.
        panelsToUse[1]=new JPanel();//This is the dice used panel.
        panelsToUse[2]=new JPanel();//this is your dice panel.

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
         * Creation of the dice buttons and adding his action listener
         */
        dice=new JButton[10];

        dice[0]=new JButton(); dice[0].addActionListener(listener);
        dice[1]=new JButton(); dice[1].addActionListener(listener);
        dice[2]=new JButton(); dice[2].addActionListener(listener);
        dice[3]=new JButton(); dice[3].addActionListener(listener);
        dice[4]=new JButton(); dice[4].addActionListener(listener);
        dice[5]=new JButton(); dice[5].addActionListener(listener);
        dice[6]=new JButton(); dice[6].addActionListener(listener);
        dice[7]=new JButton(); dice[7].addActionListener(listener);
        dice[8]=new JButton(); dice[8].addActionListener(listener);
        dice[9]=new JButton(); dice[9].addActionListener(listener);

        /**
         * Initial image of the dice
         */
        diceImage=new ImageIcon(getClass().getResource("/resources/1.jpg"));
        dice[0].setIcon(diceImage);
        dice[1].setIcon(diceImage);
        dice[2].setIcon(diceImage);
        dice[3].setIcon(diceImage);
        dice[4].setIcon(diceImage);
        dice[5].setIcon(diceImage);
        dice[6].setIcon(diceImage);
        dice[7].setIcon(diceImage);
        dice[8].setIcon(diceImage);
        dice[9].setIcon(diceImage);



        /**
         * Inactive dice panel
         */
        panelsToUse[0]=new JPanel();//Inactive dice panel
        panelsToUse[0].setPreferredSize(new Dimension(600,400));
        panelsToUse[0].setBorder(BorderFactory.createTitledBorder("Inactive Dice."));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelsToUse[0], constraints);

        /**
         * Dice used panel
         */
        panelsToUse[1]=new JPanel();//Dice used panel
        panelsToUse[1].setPreferredSize(new Dimension(600,400));
        panelsToUse[1].setBorder(BorderFactory.createTitledBorder("Dice Used."));
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelsToUse[1], constraints);

        /**
         * Your score panel
         */
        yourScoreMessage=new JTextArea();
        yourScoreMessage.setPreferredSize(new Dimension(600,400));
        yourScoreMessage.setBorder(BorderFactory.createTitledBorder("Your Score."));
        yourScoreMessage.setText("1 dice = 1 point."
                                +"\n2 dice = 3 point."
                                +"\n3 dice = 5 point."
                                +"\n4 dice = 10 point."
                                +"\n5 dice = 15 point."
                                +"\n6 dice = 21 point."
                                +"\n7 dice = 28 point."
                                +"\n8 dice = 36 point."
                                +"\n9 dice = 45 point."
                                +"\n10 dice = 55 point."
                                +"\n \nTOTAL POINTS: "+geekOutMasters.getTotalPoints());
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
        panelsToUse[2]=new JPanel();//Your dice panel
        panelsToUse[2].setPreferredSize(new Dimension(600,400));
        panelsToUse[2].setBorder(BorderFactory.createTitledBorder("Your dice."));
        panelsToUse[2].add(dice[0]); dice[0].setEnabled(false);
        panelsToUse[2].add(dice[1]); dice[1].setEnabled(false);
        panelsToUse[2].add(dice[2]); dice[2].setEnabled(false);
        panelsToUse[2].add(dice[3]); dice[3].setEnabled(false);
        panelsToUse[2].add(dice[4]); dice[4].setEnabled(false);
        panelsToUse[2].add(dice[5]); dice[5].setEnabled(false);
        panelsToUse[2].add(dice[6]); dice[6].setEnabled(false);
        panelsToUse[2].add(dice[7]); dice[7].setEnabled(false);
        panelsToUse[2].add(dice[8]); dice[8].setEnabled(false);
        panelsToUse[2].add(dice[9]); dice[9].setEnabled(false);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelsToUse[2], constraints);

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
            /**
             * Button to start the game
             */
            if(e.getSource()==play)
            {
                /**
                 *
                 */
                geekOutMasters.determinateFace();
                faces=geekOutMasters.getFaces();

                /**
                 * Round count
                 */
                roundCount++;
                /**
                 * Button activation
                 */
                for(int i=0; i < dice.length; i++)
                {
                    dice[i].setEnabled(true);
                }

                /**
                 * adding the dice in inactive dice panel
                 */
                for(int i=0; i < dice.length; i++)
                {
                    panelsToUse[2].remove(dice[i]);//Removing of your dice panel
                    panelsToUse[0].add(dice[i]);//Introducing in inactive dice panel
                    dice[i].setEnabled(false);
                    if(i == 2)
                    {
                        break;
                    }
                }

                /**
                 * Add images at the panel
                 */
                flagPlay++;
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[0] + ".jpg")));
                dice[0].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[1] + ".jpg")));
                dice[1].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[2] + ".jpg")));
                dice[2].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[3] + ".jpg")));
                dice[3].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[4] + ".jpg")));
                dice[4].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[5] + ".jpg")));
                dice[5].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[6] + ".jpg")));
                dice[6].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[7] + ".jpg")));
                dice[7].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[8] + ".jpg")));
                dice[8].setIcon(diceImage);
                diceImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + faces[9] + ".jpg")));
                dice[9].setIcon(diceImage);

                /**
                 * Once the user press the play button, it will be disabled
                 */
                if(flagPlay==1)
                {
                    play.setEnabled(false);
                }
            }

            /**
             * Dice 1 button
             */
            if(e.getSource()==dice[0])
            {
                boolean state=false;
                while(state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[0] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[0] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[0] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[0]);
                            panelsToUse[1].add(dice[0]);
                            dice[0].setEnabled(false);
                            dice[0].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[0] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[0]);
                        panelsToUse[1].add(dice[0]);
                        dice[0].setEnabled(false);
                        dice[0].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[0] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[0]);
                        panelsToUse[1].add(dice[0]);
                        dice[0].setEnabled(false);
                        dice[0].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[0] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[0]);
                        panelsToUse[1].add(dice[0]);
                        dice[0].setEnabled(false);
                        dice[0].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 2 button
             */
            if(e.getSource()==dice[1])
            {
                boolean state=false;
                while(state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     * */
                    if (faces[1] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }

                    if (faces[1] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[1] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[1]);
                            panelsToUse[1].add(dice[1]);
                            dice[1].setEnabled(false);
                            dice[1].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[1] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[1]);
                        panelsToUse[1].add(dice[1]);
                        dice[1].setEnabled(false);
                        dice[1].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[1] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[1]);
                        panelsToUse[1].add(dice[1]);
                        dice[1].setEnabled(false);
                        dice[1].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[1] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[1]);
                        panelsToUse[1].add(dice[1]);
                        dice[1].setEnabled(false);
                        dice[1].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 3 button
             */
            if(e.getSource()==dice[2])
            {
                boolean state=false;
                while(state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[2] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[2] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[2] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[2]);
                            panelsToUse[1].add(dice[2]);
                            dice[2].setEnabled(false);
                            dice[2].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[2] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[2]);
                        panelsToUse[1].add(dice[2]);
                        dice[2].setEnabled(false);
                        dice[2].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[2] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[2]);
                        panelsToUse[1].add(dice[2]);
                        dice[2].setEnabled(false);
                        dice[2].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[2] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[2]);
                        panelsToUse[1].add(dice[2]);
                        dice[2].setEnabled(false);
                        dice[2].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 4 button
             */
            if(e.getSource()==dice[3])
            {
                boolean state=false;
                while (state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[3] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[3] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[3] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[3]);
                            panelsToUse[1].add(dice[3]);
                            dice[3].setEnabled(false);
                            dice[3].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[3] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[3]);
                        panelsToUse[1].add(dice[3]);
                        dice[3].setEnabled(false);
                        dice[3].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[3] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[3]);
                        panelsToUse[1].add(dice[3]);
                        dice[3].setEnabled(false);
                        dice[3].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[3] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[3]);
                        panelsToUse[1].add(dice[3]);
                        dice[3].setEnabled(false);
                        dice[3].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 5 button
             */
            if(e.getSource()==dice[4])
            {
                boolean state=false;
                while (state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[4] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[4] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[4] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[4]);
                            panelsToUse[1].add(dice[4]);
                            dice[4].setEnabled(false);
                            dice[4].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[4] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[4]);
                        panelsToUse[1].add(dice[4]);
                        dice[4].setEnabled(false);
                        dice[4].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[4] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[4]);
                        panelsToUse[1].add(dice[4]);
                        dice[4].setEnabled(false);
                        dice[4].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[4] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[4]);
                        panelsToUse[1].add(dice[4]);
                        dice[4].setEnabled(false);
                        dice[4].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 6 button
             */
            if(e.getSource()==dice[5])
            {
                boolean state=false;
                while (state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[5] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[5] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[5] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[5]);
                            panelsToUse[1].add(dice[5]);
                            dice[5].setEnabled(false);
                            dice[5].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[5] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[5]);
                        panelsToUse[1].add(dice[5]);
                        dice[5].setEnabled(false);
                        dice[5].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[5] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[5]);
                        panelsToUse[1].add(dice[5]);
                        dice[5].setEnabled(false);
                        dice[5].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[5] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[5]);
                        panelsToUse[1].add(dice[5]);
                        dice[5].setEnabled(false);
                        dice[5].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 7 button
             */
            if(e.getSource()==dice[6])
            {
                boolean state=false;
                while (state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[6] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[6] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[6] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[6]);
                            panelsToUse[1].add(dice[6]);
                            dice[6].setEnabled(false);
                            dice[6].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[6] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[6]);
                        panelsToUse[1].add(dice[6]);
                        dice[6].setEnabled(false);
                        dice[6].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[6] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[6]);
                        panelsToUse[1].add(dice[6]);
                        dice[6].setEnabled(false);
                        dice[6].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[6] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[6]);
                        panelsToUse[1].add(dice[6]);
                        dice[6].setEnabled(false);
                        dice[6].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 8 button
             */
            if(e.getSource()==dice[7]) {
                boolean state = false;
                while (state == false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[7] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[7] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[7] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[7]);
                            panelsToUse[1].add(dice[7]);
                            dice[7].setEnabled(false);
                            dice[7].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[7] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[7]);
                        panelsToUse[1].add(dice[7]);
                        dice[7].setEnabled(false);
                        dice[7].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[7] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[7]);
                        panelsToUse[1].add(dice[7]);
                        dice[7].setEnabled(false);
                        dice[7].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[7] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[7]);
                        panelsToUse[1].add(dice[7]);
                        dice[7].setEnabled(false);
                        dice[7].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 9 button
             */
            if(e.getSource()==dice[8])
            {
                boolean state=false;
                while (state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[8] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[8] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[8] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[8]);
                            panelsToUse[1].add(dice[8]);
                            dice[8].setEnabled(false);
                            dice[8].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[8] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[8]);
                        panelsToUse[1].add(dice[8]);
                        dice[8].setEnabled(false);
                        dice[8].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[8] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[8]);
                        panelsToUse[1].add(dice[8]);
                        dice[8].setEnabled(false);
                        dice[8].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[8] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[8]);
                        panelsToUse[1].add(dice[8]);
                        dice[8].setEnabled(false);
                        dice[8].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Dice 10 button
             */
            if(e.getSource()==dice[9])
            {
                boolean state=false;
                while(state==false) {
                    /**
                     * Conditionals of the faces of the dice
                     */
                    if (faces[9] == 1)//1: face of 42
                    {
                        geekOutMasters.action42();
                        break;
                    }
                    if (faces[9] == 2)//2: face of dragon
                    {
                        geekOutMasters.dragonAction();
                        break;
                    }
                    if (faces[9] == 3)//3: face of heart
                    {
                        if (panelsToUse[0].getComponentCount() == 0) {
                            JOptionPane.showMessageDialog(null, "There are no dice in the inactive dice section.");
                        } else {
                            panelsToUse[2].remove(dice[9]);
                            panelsToUse[1].add(dice[9]);
                            dice[9].setEnabled(false);
                            dice[9].updateUI();
                            panelsToUse[2].updateUI();
                            panelsToUse[1].updateUI();
                            geekOutMasters.heartAction(panelsToUse, dice, diceImage, faces);
                            break;
                        }
                    }
                    if (faces[9] == 4)//4: face of hero
                    {
                        panelsToUse[2].remove(dice[9]);
                        panelsToUse[1].add(dice[9]);
                        dice[9].setEnabled(false);
                        dice[9].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.heroAction(panelsToUse, dice, diceImage, faces);
                        break;
                    }
                    if (faces[9] == 5)//5: face of meeple
                    {
                        panelsToUse[2].remove(dice[9]);
                        panelsToUse[1].add(dice[9]);
                        dice[9].setEnabled(false);
                        dice[9].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.meepleAction(dice, diceImage, e, faces);
                        break;
                    }
                    if (faces[9] == 6)//6: face of ship
                    {
                        panelsToUse[2].remove(dice[9]);
                        panelsToUse[1].add(dice[9]);
                        dice[9].setEnabled(false);
                        dice[9].updateUI();
                        panelsToUse[2].updateUI();
                        panelsToUse[1].updateUI();
                        geekOutMasters.shipAction(panelsToUse, dice, e);
                        break;
                    }
                }
            }

            /**
             * Help button
             */
            if(e.getSource()==help)
            {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /**
             * Button to exit the game
             */
            if(e.getSource()==exit)
            {
                System.exit(0);
            }
        }
    }
}
