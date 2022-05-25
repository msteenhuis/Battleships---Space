import java.util.ArrayList;
import java.util.Scanner;
import static java.awt.Color.white;

public class MethodBank {

    private ArrayList<Ships> player1 = new ArrayList<>();
    private ArrayList<Ships> player2 = new ArrayList<>();
    private Coordinate[][][] map1;
    private Coordinate[][][] map2;

    public MethodBank()
    {
        ArrayList<Coordinate> cArr11 = new ArrayList<>();
        ArrayList<Coordinate> cArr12 = new ArrayList<>();
        ArrayList<Coordinate> dArr11 = new ArrayList<>();
        ArrayList<Coordinate> dArr12 = new ArrayList<>();
        ArrayList<Coordinate> crArr1 = new ArrayList<>();
        ArrayList<Coordinate> bArr1 = new ArrayList<>();
        ArrayList<Coordinate> caArr1 = new ArrayList<>();

        Ships c11 = new Corvette (cArr11,"Corvette", "Scout", 3);
        Ships c12 = new Corvette (cArr12,"Corvette", "Scout", 3);
        Ships d11 = new Destroyer (dArr11,"Destroyer", "Laser", 4);
        Ships d12 = new Destroyer (dArr12,"Destroyer", "Laser", 4);
        Ships cr1 = new Cruiser (crArr1,"Cruiser", "Torpedo", 5);
        Ships b1 = new Battleship (bArr1,"Battleship", "Shell", 6);
        Ships ca1 = new Carrier (caArr1,"Carrier", "Fighter Wing", 6);

        player1.add(c11);
        player1.add(c12);
        player1.add(d11);
        player1.add(d12);
        player1.add(cr1);
        player1.add(b1);
        player1.add(ca1);

        ArrayList<Coordinate> cArr21 = new ArrayList<>();
        ArrayList<Coordinate> cArr22 = new ArrayList<>();
        ArrayList<Coordinate> dArr21 = new ArrayList<>();
        ArrayList<Coordinate> drArr22 = new ArrayList<>();
        ArrayList<Coordinate> crArr2 = new ArrayList<>();
        ArrayList<Coordinate> bArr2 = new ArrayList<>();
        ArrayList<Coordinate> caArr2 = new ArrayList<>();

        Ships c21 = new Corvette (cArr21,"Corvette", "Scout", 3);
        Ships c22 = new Corvette (cArr22,"Corvette", "Scout", 3);
        Ships d21 = new Destroyer (dArr21,"Destroyer", "Laser", 4);
        Ships d22 = new Destroyer (drArr22,"Destroyer", "Laser", 4);
        Ships cr2 = new Cruiser (crArr2,"Cruiser", "Torpedo", 5);
        Ships b2 = new Battleship (bArr2,"Battleship", "Shell", 6);
        Ships ca2 = new Carrier (caArr2,"Carrier", "Fighter Wing", 6);

        player2.add(c21);
        player2.add(c22);
        player2.add(d21);
        player2.add(d22);
        player2.add(cr2);
        player2.add(b2);
        player2.add(ca2);

        this.map1 = new Coordinate[11][11][11];
        this.map2 = new Coordinate[11][11][11];
    }

    public void Run()
    {
        //this.setup();
        //this.placement();
        //this.play();
        //this.save();
    }

    public void setMap(Coordinate[][][] m)
    {
        for (int x = 0; x < 11; x++)
        {
            for (int y = 0; y < 11; y++)
            {
                for (int z = 0; z < 11; z++)
                {
                    Coordinate temp = new Coordinate(x, y, z, false, false, false,"\033[0;33m");
                    m[x][y][z] = temp;
                }
            }
        }
    }

    public Coordinate[][][] getMap1()
    {
        return map1;
    }

    public Coordinate[][][] getMap2()
    {
        return map2;
    }

    public ArrayList<Ships> getPlayer1()
    {
        return player1;
    }

    public ArrayList<Ships> getPlayer2()
    {
        return player2;
    }


    public static void printMap(Coordinate[][][] m)
    {
        System.out.println("  0  1  2  3  4  5  6  7  8  9  10");
        for (int x = 0; x < 11; x++)
        {
            System.out.print(x + " ");
            for (int y = 0; y < 11; y++)
            {
                int z = 0;
                boolean canPrint = false;
                while(!canPrint) {
                    if (m[x][y][z].getAmRevealed())
                    {
                        System.out.print(m[x][y][z].getColorIndicator() + z + "\u001b[0m" + " ");
                        canPrint = true;
                    }
                    else if (z == 10)
                    {
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

    public boolean collision(ArrayList<Ships> arr)
    {
        boolean output = true;
        return output;

    } // Check to see if a coordinate may have two ships or not.

    public void placeShips(Coordinate[][][] map, ArrayList<Ships> arr, boolean amRevealed)
    {
        Scanner input = new Scanner(System.in);
        String direction = "";
        int x = 0;
        int y = 0;
        int z = 0;
        boolean isValid = false;
        for (int i = 0; i < arr.size(); i++)
        {
            System.out.print((i + 1) + ". ");
            System.out.println("Input the X coordinate for your " + arr.get(i).getClassType() + ".");
            x = Integer.parseInt(input.nextLine());
            System.out.println("Input the Y coordinate for your " + arr.get(i).getClassType() + ".");
            y = Integer.parseInt(input.nextLine());
            System.out.println("Input the Z coordinate for your " + arr.get(i).getClassType() + ".");
            z = Integer.parseInt(input.nextLine());

            System.out.print("Input the direction you would like your ship to face, vertically or horizontally. \nTo select vertical, input (v). To select horizontal, input (h).");
            direction = input.nextLine();

            for (int j = 0; j < arr.get(i).getLen(); j++) {
                Coordinate temp = new Coordinate(x, y, z, false, true, amRevealed,"\033[0;33m");
                if (direction.equals("v")){
                    arr.get(i).getCoordArr().add(temp);
                    y--;
                }
                if (direction.equals("h")){
                    arr.get(i).getCoordArr().add(temp);
                    x--;
                }
            }
            isValid = collision(arr);

            while (!isValid) {
                System.out.print("error");
                System.out.println("Input the X coordinate for your " + arr.get(i).getClassType() + ".");
                x = Integer.parseInt(input.nextLine());
                System.out.println("Input the Y coordinate for your " + arr.get(i).getClassType() + ".");
                y = Integer.parseInt(input.nextLine());
                System.out.println("Input the Z coordinate for your " + arr.get(i).getClassType() + ".");
                z = Integer.parseInt(input.nextLine());

                System.out.print("Input the direction you would like your ship to face, vertically or horizontally. \nTo select vertical, input (v). To select horizontal, input (h).");
                direction = input.nextLine();
                for (int j = 0; j < arr.get(i).getLen(); j++) {
                    Coordinate temp = new Coordinate(x, y, z, false, false, amRevealed, "\033[0;33m");
                    if (direction.equals("v")){
                        arr.get(i).getCoordArr().add(temp);
                        y--;
                    }
                    if (direction.equals("h")){
                        arr.get(i).getCoordArr().add(temp);
                        x--;
                    }
                }
                isValid = collision(arr);
            }

            for (int k = 0; k < arr.get(i).getLen(); k++) {
                Coordinate temp = new Coordinate(x, y, z, false, false, amRevealed, "\033[0;33m");
                temp.setColorIndicator("\033[0;33m");
                if (direction.equals("v")){
                    temp = map[x][y][z];
                    arr.get(i).getCoordArr().add(temp);

                    y--;
                }
                else{
                    temp = map[x][y][z];
                    arr.get(i).getCoordArr().add(temp);
                    x--;
                }
            }
            System.out.println("Ship added!");
            }
        }

    public void play(String playerOne, String playerTwo)
    {
        while (gameOver() != true)
        {
        }
    }

    public void takeTurn()
    {

    }

    public boolean gameOver()
    {
        boolean output = false;
        int counterOne = 0;
        int counterTwo = 0;
        for (Ships v : player1)
        {
            if (v.isDestroyed(v))
            {
                counterOne++;
            }
        }
        for (Ships v : player2)
        {
            if (v.isDestroyed(v))
            {
                counterTwo++;
            }
        }
        if (counterOne == 7 || counterTwo == 7)
        {
            output = true;
        }
        return output;
    }

}
