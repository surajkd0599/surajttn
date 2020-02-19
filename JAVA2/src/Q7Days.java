public class Q7Days {

        public static void main(String args[]) {
            int k = 8;
            int h = 0, m = 0, s = 0, d = 0;
            d = k / 86400;
            System.out.println("Days: " + d);
            d= k % 86400;
            h= d / 3600;
            System.out.println("hours: " + h);
            h=d % 3600;
            m=h/60;
            System.out.println("minutes: " +m);
            m=h % 60;
            s=m;
            System.out.println("seconds: "+s);
        }
    }

