import java.util.Scanner;

public class ProperCase {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String name =sc.nextLine();

        name=name.toLowerCase();
        name=name.trim();
        String firstChar=(name.charAt(0)+"").toUpperCase();
        System.out.println(name);
        for (int i = 1; i < name.length(); i++) {
            int j=i;
            while (name.charAt(i)==' ') {
                
                if (name.charAt(j)!= ' ') {
                    name=name.substring(1, i+1)+(name.charAt(j)+"").toUpperCase()+name.substring(j+1);  
                }
                j++;
                
                
            }
        }
        System.out.println(firstChar+name);
        sc.close();
        
    }
}