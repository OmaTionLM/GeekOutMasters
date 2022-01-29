package geekOutMasters;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class GeekOutMasters
{
    /**
     * Attributes
     */
    private Dice[] dice;
    private int[] faces;

    /*
    * Constructor
    */
    public GeekOutMasters()
    {
        dice=new Dice[10];

        dice[0]=new Dice();
        dice[1]=new Dice();
        dice[2]=new Dice();
        dice[3]=new Dice();
        dice[4]=new Dice();
        dice[5]=new Dice();
        dice[6]=new Dice();
        dice[7]=new Dice();
        dice[8]=new Dice();
        dice[9]=new Dice();

        faces=new int[10];
    }

    /*
    * Method to assign his visible face
    */
    public void determinateFace()
    {
        faces[0]=dice[0].getVisibleFace();
        faces[1]=dice[1].getVisibleFace();
        faces[2]=dice[2].getVisibleFace();
        faces[3]=dice[3].getVisibleFace();
        faces[4]=dice[4].getVisibleFace();
        faces[5]=dice[5].getVisibleFace();
        faces[6]=dice[6].getVisibleFace();
        faces[7]=dice[7].getVisibleFace();
        faces[8]=dice[8].getVisibleFace();
        faces[9]=dice[9].getVisibleFace();
    }

    /*
    * "You Lose" is a method
     */
    public void youLose(JButton playButton, JButton[] ADice, JPanel[] APanels)
    {
        JOptionPane.showMessageDialog(null, "You got no points in this round, good luck in the next round.");
        for(int i=0; i < ADice.length; i++)
        {
            APanels[0].removeAll();
            APanels[1].removeAll();
            APanels[2].add(ADice[i]);
            ADice[i].setEnabled(false);
            APanels[0].updateUI();
            APanels[1].updateUI();
            APanels[2].updateUI();
            ADice[i].updateUI();
        }
        playButton.setEnabled(true);
    }

    /*
    * "You Win" is a method
     */
    public void youWin(JButton playButton, JButton[] ADice, JPanel[] APanels)
    {
        for(int i=0; i < ADice.length; i++)
        {
            APanels[0].removeAll();
            APanels[1].removeAll();
            APanels[2].add(ADice[i]);
            ADice[i].setEnabled(false);
            APanels[0].updateUI();
            APanels[1].updateUI();
            APanels[2].updateUI();
            ADice[i].updateUI();
        }
        playButton.setEnabled(true);
    }

    /**
     *  42: This dice will add you points.
     */
    public void action42()
    {
        JOptionPane.showMessageDialog(null, "This dice will make you get points.");
    }

    /**
     * Dragon: This dice will take away the points you have obtained in the round.
     */
    public void dragonAction()
    {
        JOptionPane.showMessageDialog(null, "This dice will take away the points you have obtained in the round.");
    }

    /**
     * Heart: Allows you to take a dices from the inactive dice section and roll it to make it a new active dice.
     */
    public void heartAction(JPanel[] APanel, JButton[] ADice, ImageIcon AImageIcon,  int[] AFaces)
    {
        Random randomNumber = new Random();
        JOptionPane.showMessageDialog(null,"A dice will be rerolled from the inactive dice section");
        for(int i=0; i < ADice.length; i++)
        {
            if(!ADice[i].isEnabled())
            {
                ADice[i].setIcon(null);
                AFaces[i] = randomNumber.nextInt(6) + 1;
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                ADice[i].setIcon(AImageIcon);
                APanel[0].remove(ADice[i]);
                APanel[2].add(ADice[i]);
                ADice[i].setEnabled(true);
                ADice[i].updateUI();
                APanel[0].updateUI();
                APanel[1].updateUI();
                APanel[2].updateUI();
                break;
            }
        }
    }

    /**
     * Hero: Allows any unused dice (active dice section) to be flipped over and placed on its opposite side.
     */
    public void heroAction(JPanel[] APanel, JButton[] ADice, ImageIcon AImageIcon, int[] AFaces, int flag, int numberDice)
    {
        boolean state=false;
        while (state==false){
            if (AFaces[numberDice] == 1) {
                AFaces[numberDice] = 3;
                ADice[numberDice].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
                ADice[numberDice].setIcon(AImageIcon);
                ADice[numberDice].updateUI();
                APanel[2].updateUI();
                break;
            }
            if (AFaces[numberDice] == 2) {
                AFaces[numberDice] = 4;
                ADice[numberDice].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
                ADice[numberDice].setIcon(AImageIcon);
                ADice[numberDice].updateUI();
                APanel[2].updateUI();
                break;
            }
            if (AFaces[numberDice] == 3) {
                AFaces[numberDice] = 1;
                ADice[numberDice].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
                ADice[numberDice].setIcon(AImageIcon);
                ADice[numberDice].updateUI();
                APanel[2].updateUI();
                break;
            }
            if (AFaces[numberDice] == 4) {
                AFaces[numberDice] = 2;
                ADice[numberDice].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
                ADice[numberDice].setIcon(AImageIcon);
                ADice[numberDice].updateUI();
                APanel[2].updateUI();
                break;
            }
            if (AFaces[numberDice] == 5) {
                AFaces[numberDice] = 6;
                ADice[numberDice].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
                ADice[numberDice].setIcon(AImageIcon);
                ADice[numberDice].updateUI();
                APanel[2].updateUI();
                break;
            }
            if (AFaces[numberDice] == 6) {
                AFaces[numberDice] = 5;
                ADice[numberDice].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
                ADice[numberDice].setIcon(AImageIcon);
                ADice[numberDice].updateUI();
                APanel[2].updateUI();
                break;
            }
        }
    }

    /**
     * Meeple: Allow you to re-roll another dice in play, that is, from the active dice section.
     */
    public void meepleAction(JPanel[] APanel,JButton[] ADice, ImageIcon AImageIcon, int[] AFaces, int numberDice)
    {
        Random randomNumber=new Random();
        AFaces[numberDice]= randomNumber.nextInt(6)+1;
        ADice[numberDice].setIcon(null);
        AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[numberDice] + ".jpg")));
        ADice[numberDice].setIcon(AImageIcon);
        ADice[numberDice].updateUI();
        APanel[2].updateUI();
    }

    /**
     * Ship: This dice sends an unused dice (from the active dice section) to inactive dice section.
     */
    public void shipAction(JPanel[] APanel, JButton[] ADice, int numberDice)
    {
        APanel[2].remove(ADice[numberDice]);
        APanel[0].add(ADice[numberDice]);
        ADice[numberDice].setEnabled(false);
        APanel[2].updateUI();
        APanel[0].updateUI();
        ADice[numberDice].updateUI();
    }

    /**
     * @return faces value.
     */
    public int[] getFaces()
    {
        return faces;
    }
}


