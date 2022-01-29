package geekOutMasters;

import java.util.Random;

/**
 * Dice class that returns a random number between 1 and 6.
 * @author Jeison Perea - jeison.perea@correounivalle.edu.co && Alan Valderrama - alan.valderrama@correounivalle.edu.co
 * @code : 2077250 - 2042836
 * @version: v1.0
 * @fecha: 01/04/2022
 */
public class Dice
{
    public int visibleFace, statePower;
    private String power;

    /**
     * Method that generates random numbers between 1 and 6.
     *
     * @return number (1,6)
     * @author Jeison Perea - jeison.perea@correounivalle.edu.co && Alan Valderrama - alan.valderrama@correounivalle.edu.co
     * @code : 2077250 - 2042836
     * @version: v1.0
     * @fecha: 01/04/2022
     */

    public int getVisibleFace() {
        Random randomNumber = new Random();
        visibleFace = randomNumber.nextInt(6) + 1;
        return visibleFace;
    }
}
