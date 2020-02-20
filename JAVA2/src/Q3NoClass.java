public class Q3NoClass
{
    public static void main(String args[])
    {

        try
        {
            throw new NoClassDefFoundError("NO Class DEF FOUND");
        }
        catch (NoClassDefFoundError n)
        {
            System.out.println("Exception: "+n.getMessage());
        }
        try
        {
            throw new ClassNotFoundException("NO CLASS");
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Exception: "+c.getMessage());
        }

    }
}
