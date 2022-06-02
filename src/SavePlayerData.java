import java.util.ArrayList;

public class SavePlayerData {
    ArrayList<Player> playerArr;

    public SavePlayerData()
    {
        this.playerArr = new ArrayList<>();
    }

    public ArrayList<Player> getPlayerArr()
    {
        return playerArr;
    }

    public void setPlayerArr(ArrayList<Player> p)
    {
        playerArr = p;
    }

    public String toString()
    {
        String output = "";
        for (int i = 0; i < playerArr.size(); i++)
        {
            output += "(" + i + ") " + playerArr.get(i).getUser() + "\n";
        }
        return output;
    }
}
