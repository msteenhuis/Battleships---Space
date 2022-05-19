import java.util.Arrays;
import java.util.ArrayList;

public class Main {

    private ArrayList<Ships> player1;
    private ArrayList<Ships> player2;
    private Coordinate[][][] map1;
    private Coordinate[][][] map2;

    public Main()
    {
        Ships c11 = new Corvette ("Corvette", "Scout");
        Ships c12 = new Corvette ("Corvette", "Scout");
        Ships d11 = new Destroyer ("Destroyer", "Laser");
        Ships d12 = new Destroyer ("Destroyer", "Laser");
        Ships cr1 = new Cruiser ("Cruiser", "Torpedo");
        Ships b1 = new Battleship ("Battleship", "Shell");
        Ships ca1 = new Carrier ("Carrier", "Fighter Wing");

        player1.add(c11);
        player1.add(c12);
        player1.add(d11);
        player1.add(d12);
        player1.add(cr1);
        player1.add(b1);
        player1.add(ca1);

        Ships c21 = new Corvette ("Corvette", "Scout");
        Ships c22 = new Corvette ("Corvette", "Scout");
        Ships d21 = new Destroyer ("Destroyer", "Laser");
        Ships d22 = new Destroyer ("Destroyer", "Laser");
        Ships cr2 = new Cruiser ("Cruiser", "Torpedo");
        Ships b2 = new Battleship ("Battleship", "Shell");
        Ships ca2 = new Carrier ("Carrier", "Fighter Wing");

        player1.add(c21);
        player1.add(c22);
        player1.add(d21);
        player1.add(d22);
        player1.add(cr2);
        player1.add(b2);
        player1.add(ca2);

        this.map1 = new Coordinate[10][10][10];
        this.map2 = new Coordinate[10][10][10];
    }

    public void Run()
    {
        //this.setup();
        //this.placement();
        //this.play();
        //this.save();
    }

    public Coordinate[][][] getMap1()
    {
        return map1;
    }

    public Coordinate[][][] getMap2()
    {
        return map2;
    }


    public void printMap(Coordinate[][][] m, ArrayList<Coordinate> s)
    {
        System.out.println("XY View");
        System.out.println("0 1 2 3 4 5 6 7 8 9 10");
        for(int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
               to
            }
            System.out.print(x + " ");
        }
    }

}
