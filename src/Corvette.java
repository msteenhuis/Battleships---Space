import java.util.ArrayList;

public class Corvette extends Ships{

    private String ability;

    public Corvette (ArrayList<Coordinate> c, String t, String a)
    {
        super(c, t);
        this.ability = a;
    }

    public void Scout(Coordinate c)
    {
        if (-1 < c.getXCoord() - 1 || 11 > c.getXCoord() + 1 || -1 < c.getYCoord() - 1 || 11 > c.getYCoord() + 1 || -1 < c.getZCoord() - 1 || 11 > c.getZCoord() + 1 )
        {
            for (int z = c.getZCoord() - 1; z < c.getZCoord() + 2; z++)
            {
                for (int x = c.getXCoord() - 1; x < c.getXCoord() + 2; x++)
                {
                    for (int y = c.getYCoord() - 1; y < c.getYCoord() + 2; y++)
                    {
                        if (c.isShipHere(shipArr, map[x][y][z]) == true)
                        {

                        }
                    }
                }
            }
        }
    }
}
