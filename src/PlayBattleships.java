import java.util.ArrayList;

public class PlayBattleships {
    public static void main(String[] args) {
        MethodBank g = new MethodBank();
        Coordinate[][][] map = g.getMap1();
        ArrayList<Ships> arr = g.getPlayer1();
        g.setMap(map);
        map[5][5][5] = new Coordinate(5,5,5,false, true, "\033[0;33m");
        for (int i = 0; i < arr.size(); i++)
        {
            g.placeShips(i, map, arr, true);
        }
        //g.printMap(map);
    }
}