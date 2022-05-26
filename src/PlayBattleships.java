import java.util.ArrayList;

public class PlayBattleships {
    public static void main(String[] args) {
        MethodBank g = new MethodBank();
        Coordinate[][][] map = g.getMap1();
        ArrayList<Ships> arr = g.getPlayer1();
        g.setMap(map);
        System.out.println(map[5][5][5].getShipHere());
        g.placeShips(map, arr, true);
        g.printMap(map);
    }
}