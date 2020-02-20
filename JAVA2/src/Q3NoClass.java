public class Q3NoClass
{
    public static void main (String args[])
    {
        try
        {
            throw new ClassNotFoundException("no class");
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Exception: "+c.getMessage());
        }
        try
        {
            throw new NoClassDefFoundError("no class Definition");
        }
        catch (NoClassDefFoundError n)
        {
            System.out.println("Exception: "+n.getMessage());
        }
        finally {
            System.out.println("THE END OF PROGRAM");
        }
    }
}