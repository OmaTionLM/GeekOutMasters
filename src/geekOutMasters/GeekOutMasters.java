package geekOutMasters;

import javax.swing.*;
import java.awt.*;

public class GeekOutMasters
{
    /**
     * Attributes
     */
    //public Dice dice1, dice2, dice3, dice4, dice5, dice6, dice7,dice8 ,dice9,dice10;
    public Dice[] dice;
    public int roundCount, totalPoints;
    public int[] faces, roundPoints;

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

    public void determinatePower(Dice aDice)
    {

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
    public void action42(JButton[] ADice, int[] faces)
    {
        //to do
    }

    /**
     * Dragon: This dice will take away the points you have obtained in the round.
     */
    public void dragonAction()
    {
        //to do
    }

    /**
     * Heart: Allows you to take a dices from the inactive dice section and roll it to make it a new active dice.
     */
    public void heartAction()
    {
        //to do
    }

    /**
     * Hero: Allows any unused dice (active dice section) to be flipped over and placed on its opposite side.
     */
    public void heroAction()
    {
        //to do
    }

    /**
     * Meeple: Allow you to re-roll another dice in play, that is, from the active dice section.
     */
    public void meepleAction()
    {
        //to do
    }

    /**
     * Ship: This dice sends an unused dice (from the active dice section) to inactive dice section.
     */
    public void shipAction()
    {
        //to do
    }


    public void startToPlay()
    {

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


