package geekOutMasters;

public class GeekOutMasters
{
    /**
     * Attributes
     */
    public Dice dice1, dice2, dice3, dice4, dice5, dice6, dice7,dice8 ,dice9,dice10;
    private int roundCount, totalPoints, roundPoints;
    private int[] faces;
    private Dice[] numberOfDice;

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

        roundPoints=0;
        roundCount=1;
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


    public void doAction()
    {
        for(int i=0; i < numberOfDice.length; i++)
        {
            if(numberOfDice.length ==1 && numberOfDice[i].getPower()=="dragon")
            {
                roundPoints=0;
            }
            if(numberOfDice[i].getPower()=="heart")
            {

            }
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


