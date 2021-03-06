import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodBank {

    private ArrayList<Ships> arr1 = new ArrayList<>();
    private ArrayList<Ships> arr2 = new ArrayList<>();
    private Coordinate[][][] map1;
    private Coordinate[][][] map2;
    private Player p1;
    private Player p2;
    private SavePlayerData s;

    public MethodBank() throws IOException {
        ArrayList<Coordinate> cArr11 = new ArrayList<>();
        ArrayList<Coordinate> cArr12 = new ArrayList<>();
        ArrayList<Coordinate> dArr11 = new ArrayList<>();
        ArrayList<Coordinate> dArr12 = new ArrayList<>();
        ArrayList<Coordinate> crArr1 = new ArrayList<>();
        ArrayList<Coordinate> bArr1 = new ArrayList<>();
        ArrayList<Coordinate> caArr1 = new ArrayList<>();

        Ships c11 = new Ships(cArr11, "Corvette", 3);
        Ships c12 = new Ships(cArr12, "Corvette", 3);
        Ships d11 = new Ships(dArr11, "Destroyer", 4);
        Ships d12 = new Ships(dArr12, "Destroyer", 4);
        Ships cr1 = new Ships(crArr1, "Cruiser", 5);
        Ships b1 = new Ships(bArr1, "Battleship", 6);
        Ships ca1 = new Ships(caArr1, "Carrier", 6);

        arr1.add(c11);
        arr1.add(c12);
        arr1.add(d11);
        arr1.add(d12);
        arr1.add(cr1);
        arr1.add(b1);
        arr1.add(ca1);

        ArrayList<Coordinate> cArr21 = new ArrayList<>();
        ArrayList<Coordinate> cArr22 = new ArrayList<>();
        ArrayList<Coordinate> dArr21 = new ArrayList<>();
        ArrayList<Coordinate> drArr22 = new ArrayList<>();
        ArrayList<Coordinate> crArr2 = new ArrayList<>();
        ArrayList<Coordinate> bArr2 = new ArrayList<>();
        ArrayList<Coordinate> caArr2 = new ArrayList<>();

        Ships c21 = new Ships(cArr21, "Corvette", 3);
        Ships c22 = new Ships(cArr22, "Corvette", 3);
        Ships d21 = new Ships(dArr21, "Destroyer", 4);
        Ships d22 = new Ships(drArr22, "Destroyer", 4);
        Ships cr2 = new Ships(crArr2, "Cruiser", 5);
        Ships b2 = new Ships(bArr2, "Battleship", 5);
        Ships ca2 = new Ships(caArr2, "Carrier", 6);

        arr2.add(c21);
        arr2.add(c22);
        arr2.add(d21);
        arr2.add(d22);
        arr2.add(cr2);
        arr2.add(b2);
        arr2.add(ca2);

        this.map1 = new Coordinate[11][11][11];
        this.map2 = new Coordinate[11][11][11];

        this.p1 = new Player(arr1,map1,"");
        this.p2 = new Player(arr2,map2,"");

        this.s = new SavePlayerData();
    }

    public void Run() throws IOException {
        this.setup();
        System.out.print("\033[H\033[2J");
        this.place();
        System.out.print("\033[H\033[2J");
        this.play();
        this.save();
    }

    public void setup() throws IOException {
        setPlayers();
        setMap(map1);
        setMap(map2);
    }

    public void place() {
        System.out.println("It is " + p1.getUser() + "'s turn to place their ships.");
        for (int i = 0; i < 7; i++)
        {
            placeShips(i, p1.getMap(), p1.getArr(), true);
        }
        hideMap(p1.getMap());
        System.out.print("\033[H\033[2J");
        System.out.println("It is " + p2.getUser() + "'s turn to place their ships.");
        for (int i = 0; i < 7; i++)
        {
            placeShips(i, p2.getMap(), p2.getArr(), true);
        }
        hideMap(p2.getMap());
    }

    public void setPlayers() throws IOException {
        Scanner input = new Scanner(System.in);
        String tempName;
        int numChoice;
        int pOne = 0;
        int pTwo = 0;
        System.out.println("PLAYER ONE");
        System.out.println("If you are a returning player, enter (1) to find your username. \nIf you are a new player, enter (2) to create a new username.");
        numChoice = Integer.parseInt(input.nextLine());
        if (numChoice == 1)
        {
            boolean isValid = false;
            SavePlayerData tempSave = new SavePlayerData();
            tempSave.setPlayerArr(s.getPlayerArr());
            System.out.print(s.toString());
            while(!isValid) {
                System.out.println("Find your username below. Enter the wanted user name by inputting its corresponding number:");
                tempSave.toString();
                pOne = Integer.parseInt(input.nextLine());
                if (pOne > -1 && pOne < s.getPlayerArr().size())
                {
                    isValid = true;
                    p1 = s.getPlayerArr().get(pOne);
                    p1.setArr(arr1);
                    p1.setMap(map1);
                }
                else
                {
                    pOne = -1;
                    System.out.println("Error: Number out of bounds");

                }
            }
        }
        if (numChoice == 2)
        {
            System.out.println("Enter a new username below:");
            tempName = input.nextLine();
            Player tempPlayer = new Player (tempName, 0, 0, 0);
            p1 = tempPlayer;
            p1.setUser(tempName);
            p1.setArr(arr1);
            p1.setMap(map1);
            s.getPlayerArr().add(tempPlayer);
        }

        System.out.println("PLAYER TWO");
        System.out.println("If you are a returning player, enter (1) to find your username. \nIf you are a new player, enter (2) to create a new username.");
        numChoice = Integer.parseInt(input.nextLine());
        if (numChoice == 1)
        {
            boolean isValid = false;
            SavePlayerData tempSave = new SavePlayerData();
            tempSave.setPlayerArr(s.getPlayerArr());
            while(!isValid) {
                System.out.println("Find your username below. Enter the wanted user name by inputting its corresponding number:");
                System.out.println(tempSave.toString());
                pTwo = Integer.parseInt(input.nextLine());
                if (pTwo > -1 && pTwo < s.getPlayerArr().size() && pOne != pTwo)
                {
                    isValid = true;
                    p2 = s.getPlayerArr().get(pTwo);
                    p2.setArr(arr2);
                    p2.setMap(map2);
                }
                else
                {
                    pTwo = -1;
                    System.out.println("Error: Number out of bounds");
                }
            }
        }
        if (numChoice == 2)
        {
            System.out.println("Enter a new username below:");
            tempName = input.nextLine();
            Player tempPlayer = new Player(tempName,0,0,0);
            p2 = tempPlayer;
            p2.setUser(tempName);
            p2.setArr(arr2);
            p2.setMap(map2);
            s.getPlayerArr().add(tempPlayer);
        }
    }

    public void setMap(Coordinate[][][] m) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                for (int z = 0; z < 11; z++) {
                    Coordinate temp = new Coordinate(x, y, z, false, false, "\033[0;33m");
                    m[x][y][z] = temp;
                }
            }
        }
    }

    public void hideMap(Coordinate[][][] m) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                for (int z = 0; z < 11; z++) {
                    m[x][y][z].setAmRevealed(false);
                }
            }
        }
    }

    public Coordinate[][][] getMap1() {
        return map1;
    }

    public Coordinate[][][] getMap2() {
        return map2;
    }

    public ArrayList<Ships> getArr1() {
        return arr1;
    }

    public ArrayList<Ships> getArr2() {
        return arr2;
    }


    public static void printMap(Coordinate[][][] m) {
        System.out.println("  0  1  2  3  4  5  6  7  8  9");
        for (int y = 0; y < 10; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < 10; x++) {
                int z = 0;
                boolean canPrint = false;
                while (!canPrint) {
                    if (m[x][y][z].getAmRevealed() == true) {
                        canPrint = true;
                        System.out.print(m[x][y][z].getColorIndicator() + m[x][y][z].getZCoord() + " " + "\u001B[0m" + " ");
                    }
                    if (z == 10) {
                        canPrint = true;
                        System.out.print("   ");
                    }
                    z++;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean placeCheck(Coordinate[][][] map, ArrayList<Coordinate> arr) {
        boolean output = true;
        for (Coordinate v : arr) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    for (int z = 0; z < 10; z++) {
                        if (map[x][y][z].getShipHere()) {
                            if (v.getShipHere() && map[x][y][z].getXCoord() == v.getXCoord() && map[x][y][z].getYCoord() == v.getYCoord() && map[x][y][z].getZCoord() == v.getZCoord()) {
                                output = false;
                                System.out.println(output + "1, " + map[x][y][z].getXCoord() + map[x][y][z].getXCoord() + map[x][y][z].getXCoord() + "\n" + v.getXCoord() + v.getYCoord() + v.getZCoord());
                            }
                        }
                    }
                }
            }
        }
        for (Coordinate v : arr)
        {
            if (v.getYCoord() > 10) {
                output = false;
            }
            if (v.getXCoord() > 10) {
                output = false;
            }
        }
        return output;
    }

    public void placeShips(int counter, Coordinate[][][] map, ArrayList<Ships> arr, boolean amRevealed) {
        int x = 0;
        int y = 0;
        int z = 0;
        String direction = "v";
        boolean isValid = false;
        Scanner input = new Scanner(System.in);
            while (!isValid) {
            System.out.print((counter + 1) + ". ");
            System.out.println("Input the X coordinate for the front of your " + arr.get(counter).getClassType() + ". It must be between 0 and 9.");
            x = Integer.parseInt(input.nextLine());
            System.out.println("Input the Y coordinate for the front of your " + arr.get(counter).getClassType() + ". It must be between 0 and 9.");
            y = Integer.parseInt(input.nextLine());
            System.out.println("Input the Z coordinate for the front of your " + arr.get(counter).getClassType() + ". It must be between 0 and 9.");
            z = Integer.parseInt(input.nextLine());
            System.out.println("Input the direction you would like your " + arr.get(counter).getClassType() + " to face. Input (v) for the ship to face vertically, and (h) for the ship to face horizontally.");
            direction = input.nextLine();

            Coordinate[][][] tempMap = new Coordinate[17][17][11];
            setMap(tempMap);
            ArrayList<Coordinate> tempArr = new ArrayList<>();

            if (direction.equals("v")) {
                for (int j = 0; j < arr.get(counter).getLen(); j++) {
                    Coordinate tempCoord = new Coordinate(x, y + j, z, true, true, "\033[0;33m");
                    tempMap[x][y + j][z] = tempCoord;
                    tempArr.add(tempCoord);
                    System.out.println(tempCoord.toString());
                }
            } else {
                for (int j = 0; j < arr.get(counter).getLen(); j++) {
                    Coordinate tempCoord = new Coordinate(x + j, y , z, true, true, "\033[0;33m");
                    tempMap[x + j][y][z] = tempCoord;
                    tempArr.add(tempCoord);
                    System.out.println(tempCoord.toString());
                }
            }
            isValid = placeCheck(map, tempArr);
            if (isValid) {
                arr.get(counter).setCoordArr(tempArr);
                if (direction.equals("v")) {
                    for (int j = 0; j < arr.get(counter).getLen(); j++) {
                        map[x][y + j][z] = arr.get(counter).getCoordArr().get(j);
                    }
                } else {
                    for (int j = 0; j < arr.get(counter).getLen(); j++) {
                        map[x + j][y][z] = arr.get(counter).getCoordArr().get(j);
                    }
                }
                System.out.println("Your " + arr.get(counter).getClassType() + " has been deployed to the battlefield!");
                printMap(map);
            }
            else if (!isValid)
            {
                System.out.println("Error: Please reenter data for your " + arr.get(counter).getClassType() + ".");
            }
        }
    }


    public void play()
    {
        int counter = 1;
        while (isGameOver() != true)
        {
            if (counter % 2 == 1)
            {
                System.out.println("Your map currently looks like this:");
                printMap(map1);
                System.out.println("The enemy's map currently looks like this:");
                printMap(map2);
                p1.takeTurn(map2, arr2);
                counter++;
                if (isGameOver())
                {
                    printMap(map2);
                    break;
                }
            }
            System.out.print("\033[H\033[2J");
            printMap(map2);

            if (counter % 2 == 0)
            {
                System.out.println("Your map currently looks like this:");
                printMap(map2);
                System.out.println("The enemy's map currently looks like this:");
                printMap(map1);
                p2.takeTurn(map1, arr2);
                counter++;
                if (isGameOver())
                {
                    printMap(map1);
                    break;
                }
            }
            System.out.print("\033[H\033[2J");
            printMap(map1);
        }
    }


    public boolean isGameOver()
    {
        boolean output = false;
        int counterOne = 0;
        int counterTwo = 0;
        for (Ships v : arr1) {
            if (v.isDestroyed())
            {
                counterOne++;
            }
            if (counterOne == arr1.size())
            {
                output = true;
                p2.setGamesWon();
                p1.setGamesLost();
                System.out.println(p2.getUser() + " has won!");
            }
        }
        for (Ships v : arr2) {
            if (v.isDestroyed())
            {
                counterTwo++;
            }
            if (counterTwo == arr2.size())
            {
                output = true;
                p1.setGamesWon();
                p2.setGamesLost();
                System.out.println(p1.getUser() + " has won!");
            }
        }
        return output;
    }


    public void save()
    {
        saveData();
        savePlayerArray();
    }

    public void savePlayerArray()
    {
        try {
            File saveData = new File("src/arraySaver");
            saveData.createNewFile();
            FileWriter writer = new FileWriter("src/arraySaver");
            for (Player v : s.getPlayerArr()) {
                writer.write(v.getUser() + "|");
                writer.write(v.getGamesWon() + "|");
                writer.write(v.getGamesLost() + "|");
                writer.write(v.getShipsDestroyed() + "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.print("Error: Cannot create file");
            e.printStackTrace();
        }
    }

    public void saveData()
    {
        try {
            File saveData = new File("src/leaderboard");
            saveData.createNewFile();
            FileWriter writer = new FileWriter("src/leaderboard");
            for (Player v : s.getPlayerArr()) {
                writer.write("<" + v.getUser() + "> ");
                writer.write("<" + v.getGamesWon() + " Games Won> ");
                writer.write("<" + v.getGamesLost() + " Games Lost> ");
                writer.write("<" + v.getShipsDestroyed() + " Ships Destroyed> \n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.print("Error: Cannot create file");
            e.printStackTrace();
        }
    }

}
