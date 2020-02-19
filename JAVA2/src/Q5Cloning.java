class Copy
{
    int x, y;
    Copy()
    {
        x = 10;
        y = 20;
    }
}
class Clone
{
    int x, y;
}
class Clone2 implements Cloneable
{
    int a;
    int b;
    Clone c = new Clone();
    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }

}
public class Cloning
{
    public static void main(String[] args) throws
            CloneNotSupportedException
    {
        Copy c = new Copy();

        System.out.println(c.x + " " + c.y);
        Copy c1 = c;
        c1.x = 100;

        System.out.println(c.x+" "+c.y);
        System.out.println(c1.x+" "+c1.y);

        Clone2 t1 = new Clone2();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        Clone2 t2 = (Clone2)t1.clone();
        t2.a = 100;
        t2.c.x = 300;
        System.out.println(t1.a + " " + t1.b + " " +t1.c.x + " " + t1.c.y);
        System.out.println(t2.a + " " + t2.b + " " + t2.c.x + " " + t2.c.y);

    }
}