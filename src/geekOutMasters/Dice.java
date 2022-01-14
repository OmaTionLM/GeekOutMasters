package geekOutMasters;

import java.util.Random;

/**
 * Dice class that returns a random number between 1 and 6.
 * @author Jeison Perea && Alan Valderrama
 * @code : 2077250 - 2042836
 * @version: v1.0
 * @fecha: 01/04/2022
 */
public class Dice
{
    public int  visibleFace, statePower;
    private String power;

    /**
        * Method that generates random numbers between 1 and 6.
         * @return number (1,6)
         * @author Jeison Perea && Alan Valderrama
         * @code : 2077250 - 2042836
         * @version: v1.0
         * @fecha: 01/04/2022
     */

    public int getVisibleFace()
    {
        Random randomNumber  = new Random();
        visibleFace = randomNumber.nextInt(6)+1;
        return visibleFace;
    }

    public String getPower(Dice aDice)
    {
        if(aDice.getVisibleFace()==1)
        {
            power="42";
        }
        if(getVisibleFace()==2)
        {
            power="dragon";
        }
        if(getVisibleFace()==3)
        {
            power="heart";
        }
        if(getVisibleFace()==4)
        {
            power="hero";
        }
        if(getVisibleFace()==5)
        {
            power="meeple";
        }
        if(getVisibleFace()==6)
        {
            power="ship";
        }

        return power;
    }
}
