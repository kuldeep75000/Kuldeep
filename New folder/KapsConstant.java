public class KapsConstant {
    static int assendingOrder(int n){
        int c=0,b=0;
        int a=n%10;
//assendingorder
        for (int i = 0; i < 4; i++) {
            int count=0;
            int right=0;
            for (int j= 0; j < 4-1; j++) {
                b=n%(int)Math.pow(10, j+1);
                c=b/(int)Math.pow(10, j);
                if(c<a){
                    a=c;
                }
            }
            //dessendingorder
            for (int j = 0; j < 4-i; j++) {
                b=n%(int)Math.pow(10, j+1);
                c=b/(int)Math.pow(10, j);
                if (c!=a) {
                    c=c*(int)Math.pow(10, count);
                    System.out.println("c="+c);
                    right=c+right;
                    System.out.println("right"+right);
                    count++;
                }
            }
            n=n/(int)Math.pow(10, 4-i);
            n=n*(int)Math.pow(10, 4-i);
            n=n+(c*(int)Math.pow(10, 4-i))+right;
            System.out.println("n="+n);
            a=n%10;
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println(assendingOrder(2156));
    }
}
