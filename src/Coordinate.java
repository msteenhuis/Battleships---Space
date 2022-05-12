public class Coordinate {
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private boolean abilityHere;
    private boolean shipHere;
    private boolean shipDamaged;

    public Coordinate (int x, int y, int z, boolean a, boolean s, boolean d)
    {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
        this.abilityHere = a;
        this.shipHere = s;
        this.shipDamaged = false;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord()
    {
        return yCoord;
    }

    public int getZCoord()
    {
        return zCoord;
    }

    public boolean getShipDamaged()
    {
        return shipDamaged;
    }
    public void setShipDamaged()
    {
        shipDamaged = true;
    }
}
