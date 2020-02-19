import java.util.*;
public class Q2Sort_String {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = scan.next();
        int j=0;
        char temp;
        String ch = "";

        char[] chars = str.toCharArray();

        for (int i = 0; i <chars.length; i++) {

            for ( j = 0; j < chars.length; j++) {

                if(chars[j]>chars[i]){
                    temp=chars[i];
                    chars[i]=chars[j];
                    chars[j]=temp;
                }

            }

        }

        for(int k=0;k<chars.length;k++){
            ch = ch + chars[k];
        }
        System.out.println("Sorted String");
        System.out.println(ch);
    }
}
