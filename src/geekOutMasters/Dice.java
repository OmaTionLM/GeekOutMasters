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
    private int  visibleFace, statePower;
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
        switch (statePower)
        {
            case 1: if(visibleFace==1)
            {
                power="Heart";
            }

            case 2: if(visibleFace==2)
            {
                power="Hero";
            }

            case 3: if(visibleFace==3)
            {
                power="warrior";
            }

            case 4: if(visibleFace==4)
            {
                power="42";
            }

            case 5: if(visibleFace==5)
            {
                power="dragon";
            }

            case 6: if(visibleFace==6)
            {
                power="ship";
            }
        }
        return visibleFace;
    }

    public String getPower()
    {
        return power;
    }
}
