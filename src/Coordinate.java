import java.util.ArrayList;

public class Coordinate {
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private boolean abilityHere;
    private boolean shipHere;
    private boolean shipDamaged;

    public Coordinate (int x, int y, int z, boolean a, boolean s, boolean d)
    {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
        this.abilityHere = a;
        this.shipHere = s;
        this.shipDamaged = false;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord()
    {
        return yCoord;
    }

    public int getZCoord()
    {
        return zCoord;
    }

    public boolean isShipHere(ArrayList<Ships> shipArr, Coordinate c)
    {
        boolean output = false;
        for (Ships v : shipArr)
        {
            ArrayList<Coordinate> tempArr = v.getCoordArr();
            for ( int i = 0; i < tempArr.size(); i++)
            {
                if ((tempArr.get(i).getXCoord() == c.getXCoord()) && (tempArr.get(i).getYCoord() == c.getYCoord()) && (tempArr.get(i).getZCoord() == c.getZCoord()))
                {
                    output = true;
                }
            }
        }
        return output;
    }

    public boolean getShipDamaged()
    {
        return shipDamaged;
    }
    public void setShipDamaged()
    {
        shipDamaged = true;
    }
}
