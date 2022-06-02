import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Ships> arr;
    private Coordinate[][][] map;
    private String user;
    private int shipsDestroyed;
    private int gamesWon;
    private int gamesLost;
    public String rank;

    public Player(ArrayList<Ships> s, Coordinate[][][] m, String u, int d, int w, int l)
    {
        this.arr = s;
        this.map = m;
        this.user = u;
        this.shipsDestroyed = d;
        this.gamesWon = w;
        this.gamesLost = l;
    }

    public Player(ArrayList<Ships> s, Coordinate[][][] m, String u)
    {
        this.arr = s;
        this.map = m;
        this.user = u;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String u)
    {
        user = u;
    }

    public void takeTurn(Coordinate[][][] enemyMap)
    {
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int z = 0;
        System.out.println("Our battery is ready, " + rank + " " + user + ". Enter the X coordinate to be fired upon:");
        x = Integer.parseInt(input.nextLine());
        System.out.println("Enter the Y coordinate to be fired upon:");
        y = Integer.parseInt(input.nextLine());
        System.out.println("Enter the Z coordinate to be fired upon:");
        z = Integer.parseInt(input.nextLine());

        System.out.print("Firing");

        if (enemyMap[x][y][z].getShipHere())
        {

        }
    }
}
