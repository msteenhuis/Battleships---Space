import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Game g = new Game();
        Coordinate[][][] map = g.getMap1();
        ArrayList<Ships> arr = g.getPlayer1();
        g.setMap(map);
        //g.printMap(map);
        g.placeShips(map,arr);
        g.printMap(map);
    }
}
