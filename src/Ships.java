public class Ships {

    private int[] coordinate;
    private Ability attribute;
    private String classType;
    private boolean[] isHit;

    public Ships(int[] coordinate, Ability attribute, String classType, boolean[] isHit)
    {
        this.coordinate = coordinate;
        this.attribute = attribute;
        this.classType = classType;
        this.isHit = isHit;
    }

    public int[] getCoordinate()
    {
        return coordinate;
    }

    public Ability getAttribute()
    {
        return attribute;
    }

    public String getClassType()
    {
        return classType;
    }

    public boolean[] getIsHit()
    {
        return isHit;
    }

    public boolean isDestroyed(Ships s)
    {
        boolean output = true;
        int counter = 0;
        boolean[] arr = getIsHit();
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != true)
            {
                output = false;
                counter++;
            }
        }
        if (output == true)
        {
            System.out.print(s.getClassType() + " has been destroyed by the enemy!");
        }

        if (output == false)
        {
            System.out.print(s.getClassType() + " is still operational. It has " + counter + " lives left.");
        }
        return output;
    }
}
