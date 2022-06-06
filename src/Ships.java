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

    public Ships()
    {
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

    public boolean isDestroyed()
    {
        boolean output = true;

        for (Coordinate v : coordArr)
        {
            if (v.getShipDamaged() != true)
            {
                output = false;
            }
        }
        return output;
    }
}
