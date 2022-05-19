import java.util.ArrayList;

public class Carrier extends Ships{

    public Carrier (ArrayList<Coordinate> c, String t, String a)
    {
        super(c,t,a);
    }
    public Carrier (String t, String a)
    {
        super(t,a);
    }
}
