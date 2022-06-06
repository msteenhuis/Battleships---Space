import java.awt.Color;
import java.util.ArrayList;

public class Coordinate {
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private boolean shipHere;
    private boolean shipDamaged;
    private boolean amRevealed;
    private String colorIndicator;

    public Coordinate (int x, int y, int z, boolean s, boolean r, String c)
    {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
        this.shipHere = s;
        this.shipDamaged = false;
        this.amRevealed = r;
        this.colorIndicator = c;
    }

    public String getColorIndicator()
    {
        return colorIndicator;
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

    public Ships findShip(ArrayList<Ships> shipArr, Coordinate c, Player p)
    {
        Ships output = new Ships();
        for (Ships v : shipArr)
        {
            ArrayList<Coordinate> tempArr = v.getCoordArr();
            for (int i = 0; i < tempArr.size(); i++)
            {
                if (v.getCoordArr().get(i).equals(c))
                {
                    v.getCoordArr().get(i).setShipDamaged();
                    System.out.println("Your fleet successfully damaged the enemy's " + v.getClassType() + ".");
                    output = v;
                    break;
                }
            }
        }
        return output;
    }

    public boolean getShipHere()
    {
        return shipHere;
    }

    public void setShipHere()
    {
        shipHere = true;
    }

    public void setColorIndicator(String c)
    {
        colorIndicator = c;
    }

    public boolean getAmRevealed()
    {
        return amRevealed;
    }

    public void setAmRevealed(boolean isRevealed)
    {
        amRevealed = isRevealed;
    }

    public boolean getShipDamaged()
    {
        return shipDamaged;
    }

    public void setShipDamaged()
    {
        shipDamaged = true;
    }

    public String toString()
    {
        return "(" + this.getXCoord() + ", " + this.getYCoord() + ", " + this.getZCoord() + ")";
    }
}
