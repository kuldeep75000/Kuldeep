public class REcDemo {
    static void printName(int count) {
        if (count <=0){
            return;
        }
        System.out.print("java");
        printName(count-1);
    }
    
public static void main(String[] args){
    for(int i=0; i<5; i++){
        System.out.println("java");
    }
}
}