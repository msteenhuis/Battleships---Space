import java.util.ArrayList;

public class Corvette extends Ships{

    public Corvette (ArrayList<Coordinate> c, String t, String a, int len)
    {
        super(c,t,a);
    }
    public Corvette (String t, String a)
    {
        super(t,a);
    }

    public void Scout(Coordinate c, Coordinate[][][] map)
    {
        if (-1 < c.getXCoord() - 1 || 11 > c.getXCoord() + 1 || -1 < c.getYCoord() - 1 || 11 > c.getYCoord() + 1 || -1 < c.getZCoord() - 1 || 11 > c.getZCoord() + 1 )
        {
            for (int z = c.getZCoord() - 1; z < c.getZCoord() + 2; z++)
            {
                for (int x = c.getXCoord() - 1; x < c.getXCoord() + 2; x++)
                {
                    for (int y = c.getYCoord() - 1; y < c.getYCoord() + 2; y++)
                    {
                        if (c.getShipHere())
                        {
                            c.setReveal(true);
                        }
                    }
                }
            }
        }
    }
}
