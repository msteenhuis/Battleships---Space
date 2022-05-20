import java.util.ArrayList;

public class Battleship extends Ships{

    public Battleship (ArrayList<Coordinate> c, String t, String a, int len)
    {
        super(c,t,a);
    }
    public Battleship (String t, String a)
    {
        super(t,a);
    }
}
