import java.util.*;
public class R {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println(" ENTER THE VALUE : ");
    int a= sc.nextInt();
    System.out.println(" ENTER THE ROTATOIN : ");
    int b= sc.nextInt();
    int legnt=(int)(String.valueOf(a).length());
    
    while (b<0) {
        b= b + legnt;

    }
    b=b%legnt;
    int right= a%(int)Math.pow(10, b);
    int left = a/(int)Math.pow(10, b);
    right = right * (int)Math.pow(10, legnt-b);
    int res= right+left;
   
    System.out.println( " your output : "+res);
    if (a==res) {
        System.out.println( "  THIS IS PALINDROM ");
    }
    sc.close();
}
}