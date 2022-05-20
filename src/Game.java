import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Ships> player1 = new ArrayList<>();
    private ArrayList<Ships> player2 = new ArrayList<>();
    private Coordinate[][][] map1;
    private Coordinate[][][] map2;

    public Game()
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

    public void setMap(Coordinate[][][] m)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                for (int z = 0; z < 10; z++)
                {
                    Coordinate temp = new Coordinate(x, y, z, false, false, " ");
                    m[x][y][z] = temp;
                }
            }
        }
    }

    public Coordinate[][][] getMap1()
    {
        return map1;
    }

    public Coordinate[][][] getMap2()
    {
        return map2;
    }

    public ArrayList<Ships> getPlayer1()
    {
        return player1;
    }

    public ArrayList<Ships> getPlayer2()
    {
        return player2;
    }


    public void printMap(Coordinate[][][] m)
    {
        System.out.println("XY View");
        System.out.println("0  1  2  3  4  5  6  7  8  9  10");
        for(int x = 0; x < 10; x++)
        {
            System.out.print(x+1 + " ");
            for (int y = 0; y < 10; y++)
            {
                for (int z = 0; z < 10; z++)
               {
                   System.out.print(m[x][y][z].getMapText() + " ");
               }
            }
            System.out.println();
        }

    }

    public boolean collision(ArrayList<Ships> arr)
    {
        return false;
    }

    public void placeShips(Coordinate[][][] map, ArrayList<Ships> arr)
    {
        Scanner input = new Scanner(System.in);
        String coord = "";
        String direction = "";
        int x;
        int y;
        int z;
        boolean isValid = false;
        for (int i = 0; i < arr.size(); i++)
        {
            while (!isValid) {
                System.out.print("Input the coordinates for your " + arr.get(i).getClassType() + ".\n Input in this format: x y z");
                coord = input.nextLine();
                int start = coord.indexOf(" ");
                x = Integer.parseInt(coord.substring(0, start));
                coord = coord.substring(start);
                start = coord.indexOf(" ");
                y = Integer.parseInt(coord.substring(start + 1, start));
                coord = coord.substring(start);
                start = coord.indexOf(" ");
                z = Integer.parseInt(coord.substring(start + 1));
                System.out.print("Input the direction you would like your ship to face, vertically or horizontally. \nTo select vertical, input (v). To select horizontal, input (h).");
                direction = input.nextLine();
                isValid = collision(arr);
                for (int j = 0; j < arr.get(i).getLen(); j++) {
                    Coordinate temp = new Coordinate(x, y, z, false, false, "█");
                }
                if (i < 3) {
                    Ships shipTemp = ()
                }
            }
        }
    }




}
