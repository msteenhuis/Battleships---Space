import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Ships> arr;
    private Coordinate[][][] map;
    private String user;
    private int shipsDestroyed;
    private int gamesWon;
    private int gamesLost;

    public Player(ArrayList<Ships> s, Coordinate[][][] m, String u, int d, int w, int l)
    {
        this.arr = s;
        this.map = m;
        this.user = u;
        this.shipsDestroyed = d;
        this.gamesWon = w;
        this.gamesLost = l;
    }

    public Player( String u, int d, int w, int l)
    {
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

    public ArrayList<Ships> getArr()
    {
        return arr;
    }

    public int getGamesWon()
    {
        return gamesWon;
    }

    public void setGamesWon()
    {
        gamesWon++;
    }

    public int getGamesLost()
    {
        return gamesLost;
    }

    public void setGamesLost()
    {
        gamesLost++;
    }

    public int getShipsDestroyed()
    {
        return shipsDestroyed;
    }

    public void setShipsDestroyed()
    {
        shipsDestroyed++;
    }

    public void setArr(ArrayList<Ships> a) {
        arr = a;
    }

    public Coordinate[][][] getMap()
    {
        return map;
    }

    public void setMap(Coordinate[][][] m)
    {
        map = m;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String u)
    {
        user = u;
    }

    public void takeTurn(Coordinate[][][] enemyMap, ArrayList<Ships> enemyShips)
    {
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int z = 0;
        Ships damagedShips = enemyMap[x][y][z].findShip(enemyShips, enemyMap[x][y][z], this);
        System.out.println("Our battery is ready," + user + ". Enter the X coordinate to be fired upon. It must be between 0 and 9:");
        x = Integer.parseInt(input.nextLine());
        System.out.println("Enter the Y coordinate to be fired upon. It must be between 0 and 9:");
        y = Integer.parseInt(input.nextLine());
        System.out.println("Enter the Z coordinate to be fired upon. It must be between 0 and 9:");
        z = Integer.parseInt(input.nextLine());

        System.out.println("Firing");

        if (enemyMap[x][y][z].getShipHere())
        {
            if (enemyMap[x][y][z].getShipDamaged())
            {
                System.out.println("Your ship has targeted a ship, but the area was already damaged!");
            }
            else
            {
                enemyMap[x][y][z].setColorIndicator("\u001B[31m");
                if (damagedShips.isDestroyed())
                {
                    this.setShipsDestroyed();
                }
            }
        }
        System.out.println("Your fleet has successfully damaged the enemey's corvette!");
        System.out.println("Your fleet has successfully destroyed the enemey's corvette!");
        enemyMap[x][y][z].setAmRevealed(true);
        enemyMap[x][y][z].setColorIndicator("\u001B[31m");
    }
}
