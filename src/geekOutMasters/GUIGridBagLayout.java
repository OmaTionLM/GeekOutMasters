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

    private Header headerProject;
    private JLabel dice1, dice2, dice3, dice4, dice5, dice6, dice7,dice8 ,dice9,dice10;
    private JButton play, help, exit;
    private JPanel dicePanel;
    private ImageIcon diceImage;
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
        this.setUndecorated(true);
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
        headerProject = new Header("Craps Game Table", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        /**
         * Button help
         */
        help=new JButton(" ? ");
        help.addActionListener(listener);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(help, constraints);

        /**
         * Button exit
         */
        exit=new JButton("Exit");
        exit.addActionListener(listener);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(exit, constraints);

        /**
         * Initial image of the dice
         */
        diceImage=new ImageIcon(getClass().getResource("/resources/42.jpg"));
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


        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
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

        }
    }
}
