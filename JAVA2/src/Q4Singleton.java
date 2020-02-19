
    public class Q4Singleton
    {
        static Q4Singleton s=null;
        String str;
        private Q4Singleton()
        {
            str="the quick brown fox jump over a lazy dog";
        }
        public static Q4Singleton getInstance()
        {
            if(s==null)
            {
                s=new Q4Singleton();
            }
            return s;
        }
        public static void main(String arg[])
        {
            Q4Singleton x= Q4Singleton.getInstance();
            Q4Singleton y= Q4Singleton.getInstance();
            Q4Singleton z= Q4Singleton.getInstance();
            x.str=(x.str).toUpperCase();
            System.out.println(x.str);
            System.out.println(y.str);
            System.out.println(z.str);

            y.str=(x.str).toLowerCase();

            System.out.println(x.str);
            System.out.println(y.str);
            System.out.println(z.str);
        }
    }


