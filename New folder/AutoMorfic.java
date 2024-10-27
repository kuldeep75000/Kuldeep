
import java.util.Scanner;

public class AutoMorfic {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int n=k.nextInt();
        int legnth = String.valueOf(n).length()--;
        int n2=n*n;
        int n1=n2%(int)Math.pow(10, legnth);
        if (n==n1) {
            System.out.println("it is automorfic");
        }
        else{
            System.out.println("it is not automorfic");
        }
        k.close();
    }
}
