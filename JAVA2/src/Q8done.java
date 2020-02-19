import java.util.*;
public class Q8done {

        Scanner sc=new Scanner(System.in);
        void withwhile()
        {
            String Str="done";
            String str1;
            int flag=1;
            while(flag==1)
            {
                str1=sc.next();
                if(str1.equalsIgnoreCase(Str))
                {
                    flag=0;
                }
                else
                {
                    int k= str1.length();
                    char d=str1.charAt(0);
                    String s=""+d;
                    char f=str1.charAt(k-1);
                    String s1=""+f;
                    if(s.equalsIgnoreCase(s1))
                    {
                        System.out.println("First and Last letters are Same");
                    }
                }
            }
        }
        void withdowhile()
        {
            String Str="done";
            String str1;
            int flag=1;
            do
            {
                str1=sc.next();
                if(str1.equalsIgnoreCase(Str))
                {
                    flag=0;
                }
                else
                {
                    int k= str1.length();
                    char d=str1.charAt(0);
                    String s=""+d;
                    char f=str1.charAt(k-1);
                    String s1=""+f;
                    if(s.equalsIgnoreCase(s1))
                    {
                        System.out.println("First and Last letters are Same");
                    }
                }

            }while(flag==1);


        }
        public static void main (String args[])
        {

            Q8done d=new Q8done();
            d.withwhile();
            d.withdowhile();
        }
    }

