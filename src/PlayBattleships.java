import java.util.ArrayList;

public class PlayBattleships {
    public static void main(String[] args) {
        MethodBank g = new MethodBank();
        Coordinate[][][] map = g.getMap1();
        ArrayList<Ships> arr = g.getPlayer1();
        g.setMap(map);
        //g.printMap(map);
        map[3][3][3].setMapText("█");
        g.printMap(map);
    }
}
