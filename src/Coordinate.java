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

    public boolean getShipHere()
    {
        return shipHere;
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

    public String mapString()
    {
        String output = "";
        if(this.getAmRevealed())
        {
            if(this.getShipHere())
            {
                if(this.getShipDamaged())
                {
                    output = "X";
                }
                else
                {
                    output = "▇";
                }
            }
        }
        return output;
    }

    public String toString()
    {
        return "(" + this.getXCoord() + ", " + this.getYCoord() + ", " + this.getZCoord() + ")";
    }

    public void setReveal(boolean b)
    {
        if (b)
        {
            amRevealed = true;
        }
        else
        {
            amRevealed = false;
        }
    }
}
