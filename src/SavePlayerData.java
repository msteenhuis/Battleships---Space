import java.io.*;
import java.util.ArrayList;

public class SavePlayerData {
    ArrayList<Player> playerArr;
    File dataSave;

    public SavePlayerData() throws IOException {
        this.playerArr = new ArrayList<>();
        this.dataSave = new File("src/arraySaver");
        reuploadArray();
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

    public void reuploadArray() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/arraySaver"));
        String line = reader.readLine();
        while (line != null)
        {
            String tempUser = line.substring(0, line.indexOf("|"));
            line = line.substring(line.indexOf("|") + 1);

            int tempWon = Integer.parseInt(line.substring(0,line.indexOf("|")));
            line = line.substring(line.indexOf("|") + 1);

            int tempLose = Integer.parseInt(line.substring(0,line.indexOf("|")));
            line = line.substring(line.indexOf("|") + 1);

            int tempShipDes = Integer.parseInt(line);
            Player tempPlayer = new Player(tempUser, tempWon, tempLose, tempShipDes);
            playerArr.add(tempPlayer);

            line = reader.readLine();
        }
        reader.close();
    }
}
