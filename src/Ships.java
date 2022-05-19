import java.util.ArrayList;
public class Ships {

    private ArrayList<Coordinate> coordArr;
    private boolean isHit;
    private String classType;
    private String ability;

    public Ships(ArrayList<Coordinate> coordArr, String classType, String ability)
    {
        this.coordArr = coordArr;
        this.classType = classType;
        this.isHit = false;
        this.ability = ability;
    }

    public Ships(String classType, String ability)
    {
        this.classType = classType;
        this.isHit = false;
        this.ability = ability;
    }

    public ArrayList<Coordinate> getCoordArr()
    {
        return coordArr;
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

    public String getAbility()
    {
        return ability;
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
        if (output == true)
        {
            System.out.print(s.getClassType() + " has been destroyed by the enemy!");
        }

        if (output == false)
        {
            System.out.print(s.getClassType() + " is still operational. It has " + counter + " lives left.");
        }
        return output;
    }
}
