import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Ships> oppoArr;
    private Coordinate[][][] map;
    private String user;
    private String password;
    private int shipsDestroyed;
    private int gamesWon;
    private int gamesLost;
    public String rank;

    public Player(ArrayList<Ships> s, Coordinate[][][] m, String u, String p, int d, int w, int l)
    {
        this.oppoArr = s;
        this.map = m;
        this.user = u;
        this.password = p;
        this.shipsDestroyed = d;
        this.gamesWon = w;
        this.gamesLost = l;
    }

    public void takeTurn(ArrayList<Ships> enemyMap)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("");
    }
}
