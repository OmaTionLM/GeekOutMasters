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
    public void heroAction(JPanel[] APanel, JButton[] ADice, ImageIcon AImageIcon, ActionEvent e, int[] AFaces)
    {
        JOptionPane.showMessageDialog(null, "Choose the dice you would like to invert its face");
        boolean state=false;
        while(state==false)
        {
            /**
             * Dice
             */
            if (e.getSource() == ADice[0])
            {
                if (AFaces[0] == 1)
                {
                    AFaces[0] = 3;
                    ADice[0].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                    ADice[0].setIcon(AImageIcon);
                    ADice[0].updateUI();
                    APanel[2].updateUI();
                    break;
                }
                if (AFaces[0] == 2) {
                    AFaces[0] = 4;
                    ADice[0].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                    ADice[0].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[0] == 3) {
                    AFaces[0] = 1;
                    ADice[0].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                    ADice[0].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[0] == 4) {
                    AFaces[0] = 2;
                    ADice[0].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                    ADice[0].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[0] == 5) {
                    AFaces[0] = 6;
                    ADice[0].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                    ADice[0].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[0] == 6) {
                    AFaces[0] = 5;
                    ADice[0].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                    ADice[0].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[1]) {
                if (AFaces[1] == 1) {
                    AFaces[1] = 3;
                    ADice[1].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                    ADice[1].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[1] == 2) {
                    AFaces[1] = 4;
                    ADice[1].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                    ADice[1].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[1] == 3) {
                    AFaces[1] = 1;
                    ADice[1].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                    ADice[1].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[1] == 4) {
                    AFaces[1] = 2;
                    ADice[1].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                    ADice[1].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[1] == 5) {
                    AFaces[1] = 6;
                    ADice[1].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                    ADice[1].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[1] == 6) {
                    AFaces[1] = 5;
                    ADice[1].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                    ADice[1].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[2]) {
                if (AFaces[2] == 1) {
                    AFaces[2] = 3;
                    ADice[2].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                    ADice[2].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[2] == 2) {
                    AFaces[2] = 4;
                    ADice[2].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                    ADice[2].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[2] == 3) {
                    AFaces[2] = 1;
                    ADice[2].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                    ADice[2].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[2] == 4) {
                    AFaces[2] = 2;
                    ADice[2].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                    ADice[2].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[2] == 5) {
                    AFaces[2] = 6;
                    ADice[2].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                    ADice[2].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[2] == 6) {
                    AFaces[2] = 5;
                    ADice[2].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                    ADice[2].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[3]) {
                if (AFaces[3] == 1) {
                    AFaces[3] = 3;
                    ADice[3].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                    ADice[3].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[3] == 2) {
                    AFaces[3] = 4;
                    ADice[3].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                    ADice[3].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[3] == 3) {
                    AFaces[3] = 1;
                    ADice[3].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                    ADice[3].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[3] == 4) {
                    AFaces[3] = 2;
                    ADice[3].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                    ADice[3].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[3] == 5) {
                    AFaces[3] = 6;
                    ADice[3].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                    ADice[3].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[3] == 6) {
                    AFaces[3] = 5;
                    ADice[3].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                    ADice[3].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[4]) {
                if (AFaces[4] == 1) {
                    AFaces[4] = 3;
                    ADice[4].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                    ADice[4].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[4] == 2) {
                    AFaces[4] = 4;
                    ADice[4].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                    ADice[4].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[4] == 3) {
                    AFaces[4] = 1;
                    ADice[4].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                    ADice[4].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[4] == 4) {
                    AFaces[4] = 2;
                    ADice[4].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                    ADice[4].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[4] == 5) {
                    AFaces[4] = 6;
                    ADice[4].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                    ADice[4].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[4] == 6) {
                    AFaces[4] = 5;
                    ADice[4].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                    ADice[4].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[5]) {
                if (AFaces[5] == 1) {
                    AFaces[5] = 3;
                    ADice[5].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                    ADice[5].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[5] == 2) {
                    AFaces[5] = 4;
                    ADice[5].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                    ADice[5].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[5] == 3) {
                    AFaces[5] = 1;
                    ADice[5].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                    ADice[5].setIcon(AImageIcon);
                }
                if (AFaces[5] == 4) {
                    AFaces[5] = 2;
                    ADice[5].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                    ADice[5].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[5] == 5) {
                    AFaces[5] = 6;
                    ADice[5].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                    ADice[5].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[5] == 6) {
                    AFaces[5] = 5;
                    ADice[5].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                    ADice[5].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[6]) {
                if (AFaces[6] == 1) {
                    AFaces[6] = 3;
                    ADice[6].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                    ADice[6].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[6] == 2) {
                    AFaces[6] = 4;
                    ADice[6].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                    ADice[6].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[6] == 3) {
                    AFaces[6] = 1;
                    ADice[6].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                    ADice[6].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[6] == 4) {
                    AFaces[6] = 2;
                    ADice[6].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                    ADice[6].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[6] == 5) {
                    AFaces[6] = 6;
                    ADice[6].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                    ADice[6].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[6] == 6) {
                    AFaces[6] = 5;
                    ADice[6].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                    ADice[6].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[7])
            {
                if (AFaces[7] == 1)
                {
                    AFaces[7] = 3;
                    ADice[7].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                    ADice[7].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[7] == 2)
                {
                    AFaces[7] = 4;
                    ADice[7].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                    ADice[7].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[7] == 3)
                {
                    AFaces[7] = 1;
                    ADice[7].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                    ADice[7].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[7] == 4) {
                    AFaces[7] = 2;
                    ADice[7].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                    ADice[7].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[7] == 5) {
                    AFaces[7] = 6;
                    ADice[7].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                    ADice[7].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[7] == 6) {
                    AFaces[7] = 5;
                    ADice[7].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                    ADice[7].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[8])
            {
                if (AFaces[8] == 1)
                {
                    AFaces[8] = 3;
                    ADice[8].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                    ADice[8].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[8] == 2)
                {
                    AFaces[8] = 4;
                    ADice[8].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                    ADice[8].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[8] == 3)
                {
                    AFaces[8] = 1;
                    ADice[8].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                    ADice[8].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[8] == 4)
                {
                    AFaces[8] = 2;
                    ADice[8].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                    ADice[8].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[8] == 5)
                {
                    AFaces[8] = 6;
                    ADice[8].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                    ADice[8].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[8] == 6)
                {
                    AFaces[8] = 5;
                    ADice[8].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                    ADice[8].setIcon(AImageIcon);
                    break;
                }
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[9])
            {
                if (AFaces[9] == 1)
                {
                    AFaces[9] = 3;
                    ADice[9].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                    ADice[9].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[9] == 2)
                {
                    AFaces[9] = 4;
                    ADice[9].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                    ADice[9].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[9] == 3)
                {
                    AFaces[9] = 1;
                    ADice[9].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                    ADice[9].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[9] == 4)
                {
                    AFaces[9] = 2;
                    ADice[9].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                    ADice[9].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[9] == 5)
                {
                    AFaces[9] = 6;
                    ADice[9].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                    ADice[9].setIcon(AImageIcon);
                    break;
                }
                if (AFaces[9] == 6)
                {
                    AFaces[9] = 5;
                    ADice[9].setIcon(null);
                    AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                    ADice[9].setIcon(AImageIcon);
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
        JOptionPane.showMessageDialog(null, "Choose the dice you want to re-roll.");
        boolean state=false;
        while (state==false)
        {
            /**
             * Dice
             */
            if (e.getSource() == ADice[0])
            {
                Random randomNumber  = new Random();
                AFaces[0]=randomNumber.nextInt(6)+1;
                ADice[0].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[0] + ".jpg")));
                ADice[0].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[1])
            {
                Random randomNumber  = new Random();
                AFaces[1]=randomNumber.nextInt(6)+1;
                ADice[1].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[1] + ".jpg")));
                ADice[1].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[2])
            {
                Random randomNumber  = new Random();
                AFaces[2]=randomNumber.nextInt(6)+1;
                ADice[2].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[2] + ".jpg")));
                ADice[2].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[3])
            {
                Random randomNumber  = new Random();
                AFaces[3]=randomNumber.nextInt(6)+1;
                ADice[3].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[3] + ".jpg")));
                ADice[3].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[4])
            {
                Random randomNumber  = new Random();
                AFaces[4]=randomNumber.nextInt(6)+1;
                ADice[4].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[4] + ".jpg")));
                ADice[4].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[5])
            {
                Random randomNumber  = new Random();
                AFaces[5]=randomNumber.nextInt(6)+1;
                ADice[5].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[5] + ".jpg")));
                ADice[5].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[6])
            {
                Random randomNumber  = new Random();
                AFaces[6]=randomNumber.nextInt(6)+1;
                ADice[6].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[6] + ".jpg")));
                ADice[6].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[7])
            {
                Random randomNumber  = new Random();
                AFaces[7]=randomNumber.nextInt(6)+1;
                ADice[7].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[7] + ".jpg")));
                ADice[7].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[8])
            {
                Random randomNumber  = new Random();
                AFaces[8]=randomNumber.nextInt(6)+1;
                ADice[8].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[8] + ".jpg")));
                ADice[8].setIcon(AImageIcon);
                break;
            }

            /**
             * Dice
             */
            if (e.getSource() == ADice[9])
            {
                Random randomNumber  = new Random();
                AFaces[9]=randomNumber.nextInt(6)+1;
                ADice[9].setIcon(null);
                AImageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/" + AFaces[9] + ".jpg")));
                ADice[9].setIcon(AImageIcon);
                break;
            }
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


