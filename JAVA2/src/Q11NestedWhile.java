public class Q11NestedWhile
{
    public static void main(String args[])
    {
        int i,j;
        int s = 0;
        int t = 1;
        i = 0;
        while(i<10)
        {
            s = s + i;
            j = i;
            while(j>0)
            {
                t = t * (j - i);
                j--;
            }

            s = s * t;
            System.out.println("T is " + t);
            i++;
        }
        System.out.println("S is " + s);
    }
}