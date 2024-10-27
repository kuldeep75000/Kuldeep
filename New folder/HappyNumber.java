public class HappyNumber {
    public static boolean HappyNumber1(int n) {
        while(n>6){
      int a=n;
      int sum=0;
      while(a!=0){
        sum=sum+(a%10)*(a%10);
        a=a/10;
      }
      n=sum;
    }
    if(n==1){
      return true;
    }
      return false;
  
}
public static void main(String[] args) {
  
  if (HappyNumber1(12)==true) {
    System.out.println("Happy number");
  }
  else{
    System.out.println("not happy number");
  }
}
}