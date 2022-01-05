package geekOutMasters;

public class GeekOutMasters
{
    /**
     * Attributes
     */
    public Dice dice1, dice2, dice3, dice4, dice5, dice6, dice7,dice8 ,dice9,dice10;
    private int roundCount, roundPoints, totalPoints;
    private int[] faces;

    public GeekOutMasters()
    {
        dice1=new Dice();
        dice2=new Dice();
        dice3=new Dice();
        dice4=new Dice();
        dice5=new Dice();
        dice6=new Dice();
        dice7=new Dice();
        dice8=new Dice();
        dice9=new Dice();
        dice10=new Dice();

        faces=new int[10];

        roundCount=1;
        roundPoints=0;
        totalPoints=0;
    }

    public void determinateFace()
    {
        faces[0]=dice1.getVisibleFace();
        faces[1]=dice2.getVisibleFace();
        faces[2]=dice3.getVisibleFace();
        faces[3]=dice4.getVisibleFace();
        faces[4]=dice5.getVisibleFace();
        faces[5]=dice6.getVisibleFace();
        faces[6]=dice7.getVisibleFace();
        faces[7]=dice8.getVisibleFace();
        faces[8]=dice9.getVisibleFace();
        faces[9]=dice10.getVisibleFace();
    }

    public void determinatePower()
    {
        dice1.getPower();
    }


    public void game()
    {
        while(roundCount!=5)
        {


            roundCount++;
        }
    }

    /**
     * @return totalPoints value.
     */
    public int getTotalPoints()
    {
        return totalPoints;
    }

    /**
     * @return roundPoints value.
     */
    public int getRoundPoints()
    {
        return roundPoints;
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
}


