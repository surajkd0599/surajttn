class MyException extends Exception
{
    MyException(String s)
    {
        super(s);
    }
}
public class Q13CustomExxception {
    public static void main(String args[]) {
        try {
            throw new MyException("ITS MY EXCEPTION");
        } catch (MyException ex) {
            System.out.println("GOT EXCEPTION");
            System.out.println(ex.getMessage());
        }
    }
}