import java.util.ArrayList;
public class Ships {

    private ArrayList<Coordinate> coordArr;
    private boolean isHit;
    public boolean isDestroyed;
    private String classType;
    private int len;

    public Ships(ArrayList<Coordinate> coordArr, String classType, int l)
    {
        this.coordArr = coordArr;
        this.classType = classType;
        this.isHit = false;
        this.isDestroyed = false;
        this.len = l;
    }


    public int getLen()
    {
        return len;
    }

    public ArrayList<Coordinate> getCoordArr()
    {
        return coordArr;
    }

    public void setCoordArr(ArrayList<Coordinate> arr)
    {
        coordArr = arr;
    }

    public String getClassType()
    {
        return classType;
    }

    public boolean getIsHit()
    {
        for (Coordinate v : coordArr)
        {
            if (v.getShipDamaged() == true)
            {
                isHit = true;
            }
        }
        return isHit;
    }

    public void damageShip(Coordinate c)
    {
        for (Coordinate v : coordArr)
        {
            if ((v.getXCoord() == c.getXCoord()) && (v.getYCoord() == c.getYCoord()) && (v.getZCoord() == c.getZCoord()))
            {
                v.setShipDamaged();
            }
        }

    }

    public boolean isDestroyed(Ships s)
    {
        boolean output = true;
        int counter = 0;

        for (Coordinate v : coordArr)
        {
            if (v.getShipDamaged() != true)
            {
                output = false;
                counter++;
            }
        }
        /**
        if (output == true)
        {
            System.out.print(s.getClassType() + " has been destroyed by the enemy!");
        }

        if (output == false)
        {
            System.out.print(s.getClassType() + " is still operational. It has " + counter + " lives left.");
        }
         **/
        return output;
    }
}
