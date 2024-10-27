public class CalcLen {
    // public static void main(String[] args) {
        static int findLine(int n,int l){
            while (n!=0){
                n=n/10;
                l++;
            }
    
        return l;
        }
        public static void main(String[] args) {
        int n=123456;
        int l=0;
        int len =findLine(n,l);
        System.out.println(len);

    }
}