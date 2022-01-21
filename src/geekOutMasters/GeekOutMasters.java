package geekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.http.WebSocket;
import java.util.Objects;
import java.util.Random;

public class GeekOutMasters
{
    /**
     * Attributes
     */
    //public Dice dice1, dice2, dice3, dice4, dice5, dice6, dice7,dice8 ,dice9,dice10;
    public Dice[] dice;
    public int roundCount, totalPoints;
    public int[] faces, roundPoints;
    public int accountant;

    //Constructor
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
        roundPoints=new int[5];

        accountant=0;

        roundPoints[0]=0;
        roundPoints[1]=0;
        roundPoints[2]=0;
        roundPoints[3]=0;
        roundPoints[4]=0;

        roundCount=1;
        totalPoints=0;
    }

    //Method to assign his visible face
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

    public int countingFaces(JButton[] ADice)
    {
        for(int i=0; i < faces.length; i++)
        {
            for(int i2=0; i2 < ADice.length; i2++)
            {
                if(ADice[i2].isEnabled() && faces[i]==1)
                {
                    accountant++;
                }
            }
        }
        return accountant;
    }

    public void images(JButton ADice, ImageIcon AImageIcon, int AFaces)
    {
        ADice.setIcon(null);
        Random randomNumber = new Random();
        AFaces = randomNumber.nextInt(6) + 1;
        AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces + ".jpg")));
        ADice.setIcon(AImageIcon);
    }

    /**
     * 1 dice= 1 point
     * 2 dice= 3 points
     * 3 dice= 6 points
     * 4 dice= 10 points
     * 5 dice= 15 points
     * 6 dice= 21 points
     * 7 dice= 28 points
     * 8 dice= 36 points
     * 9 dice= 45 points
     * 10 dice= 55 points
     */
    public void determinatePoints(JButton[] ADice)
    {
        /**
         * Points
         */
        if(countingFaces(ADice)==1)
        {
            totalPoints=1;
        }
        if(countingFaces(ADice)==2)
        {
            totalPoints=3;
        }
        if(countingFaces(ADice)==3)
        {
            totalPoints=6;
        }
        if(countingFaces(ADice)==4)
        {
            totalPoints=10;
        }
        if(countingFaces(ADice)==5)
        {
            totalPoints=15;
        }
        if(countingFaces(ADice)==6)
        {
            totalPoints=21;
        }
        if(countingFaces(ADice)==7)
        {
            totalPoints=28;
        }
        if(countingFaces(ADice)==8)
        {
            totalPoints=36;
        }
        if(countingFaces(ADice)==9)
        {
            totalPoints=45;
        }
        if(countingFaces(ADice)==10)
        {
            totalPoints=55;
        }
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
                APanel[2].updateUI();
                break;
            }
        }
    }

    /**
     * Hero: Allows any unused dice (active dice section) to be flipped over and placed on its opposite side.
     */
    public void heroAction(JPanel[] APanel, JButton[] ADice, ImageIcon AImageIcon, int[] AFaces)
    {
        JOptionPane.showMessageDialog(null,"A random dice will flip to its opposite face.");
        for(int i=0; i < ADice.length; i++)
        {
            if(ADice[i].isEnabled())
            {
                if (AFaces[i] == 1)
                {
                    AFaces[i] = 3;
                    ADice[i].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                    ADice[i].setIcon(AImageIcon);
                    ADice[i].updateUI();
                    APanel[2].updateUI();
                    break;
                }
                if (AFaces[0] == 2) {
                    AFaces[i] = 4;
                    ADice[i].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                    ADice[i].setIcon(AImageIcon);
                    ADice[i].updateUI();
                    APanel[2].updateUI();
                    break;
                }
                if (AFaces[0] == 3) {
                    AFaces[i] = 1;
                    ADice[i].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                    ADice[i].setIcon(AImageIcon);
                    ADice[i].updateUI();
                    APanel[2].updateUI();
                    break;
                }
                if (AFaces[0] == 4) {
                    AFaces[i] = 2;
                    ADice[i].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                    ADice[i].setIcon(AImageIcon);
                    ADice[i].updateUI();
                    APanel[2].updateUI();
                    break;
                }
                if (AFaces[0] == 5) {
                    AFaces[i] = 6;
                    ADice[i].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                    ADice[i].setIcon(AImageIcon);
                    ADice[i].updateUI();
                    APanel[2].updateUI();
                    break;
                }
                if (AFaces[0] == 6) {
                    AFaces[i] = 5;
                    ADice[i].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[i] + ".jpg")));
                    ADice[i].setIcon(AImageIcon);
                    ADice[i].updateUI();
                    APanel[2].updateUI();
                    break;
                }
            }
        }
    }

    /**
     * Meeple: Allow you to re-roll another dice in play, that is, from the active dice section.
     */
    public void meepleAction(JButton[] ADice, ImageIcon AImageIcon, ActionEvent e, int[] AFaces)
    {
        JOptionPane.showMessageDialog(null, "A random dice will be re-rolled");
        for(int i=0; i < ADice.length; i++)
        {

        }
    }

    /**
     * Ship: This dice sends an unused dice (from the active dice section) to inactive dice section.
     */
    public void shipAction(JPanel[] APanel, JButton[] ADice, ActionEvent e)
    {
        JOptionPane.showMessageDialog(null, "Choose the dice you want to send to the inactive dice section.");
        boolean state=false;
        while(state==false)
        {
            /**
             * Dice
             */
            if (e.getSource() == ADice[0])
            {
                APanel[2].remove(ADice[0]);
                APanel[0].add(ADice[0]);
                ADice[0].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[1])
            {
                APanel[2].remove(ADice[1]);
                APanel[0].add(ADice[1]);
                ADice[1].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[2])
            {
                APanel[2].remove(ADice[2]);
                APanel[0].add(ADice[2]);
                ADice[2].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[3])
            {
                APanel[2].remove(ADice[3]);
                APanel[0].add(ADice[3]);
                ADice[3].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[4])
            {
                APanel[2].remove(ADice[4]);
                APanel[0].add(ADice[4]);
                ADice[4].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[5])
            {
                APanel[2].remove(ADice[5]);
                APanel[0].add(ADice[5]);
                ADice[5].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[6])
            {
                APanel[2].remove(ADice[6]);
                APanel[0].add(ADice[6]);
                ADice[6].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[7])
            {
                APanel[2].remove(ADice[7]);
                APanel[0].add(ADice[7]);
                ADice[7].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[8])
            {
                APanel[2].remove(ADice[8]);
                APanel[0].add(ADice[8]);
                ADice[8].setEnabled(false);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[9])
            {
                APanel[2].remove(ADice[9]);
                APanel[0].add(ADice[9]);
                ADice[9].setEnabled(false);
                break;
            }
        }
    }

    public int goRound()
    {
        roundCount++;
        return roundCount;
    }

    /**
     * @return totalPoints value.
     */
    public int getTotalPoints()
    {
        return totalPoints;
    }

    /**
     * @return roundCount value.
     */
    public int getRoundCount()
    {
        return roundCount;
    }

    /**
     * @return faces value.
     */
    public int[] getFaces()
    {
        return faces;
    }

    /**
     * @return faces value.
     */
    public int[] getRoundPoints()
    {
        for (int i=0; i < roundCount; i++)
        {
            if(roundCount==1)
            {
                roundPoints[0]=0;
            }

            if(roundCount==2)
            {
                roundPoints[1]=0;
            }

            if(roundCount==3)
            {
                roundPoints[2]=0;
            }

            if(roundCount==4)
            {
                roundPoints[3]=0;
            }

            if(roundCount==5)
            {
                roundPoints[4]=0;
            }
        }
        return roundPoints;
    }
}


