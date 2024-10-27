// public class SquPattern {
//     public SquPattern() {
//     }
 
//     static void printStar(int var0) {
//        if (var0 != 0) {
//           System.err.print("*");
//           printStar(var0 - 1);
//        }
//     }
 
//     static void printPattern(int row, int col) {
//        if (row != 0) {
//           printStar(col);
//           System.err.println();
//           printPattern(row - 1, col);
//        }
//     }
 
//     public static void main(String[] args) {
//        printPattern(5, 5);
//     }
//  }
 public class SquPattern {


    static void print12(int  col){
       if(col<=0){
       return ;
    }
       System.out.print("*");
       print12(col-1);

  }

  static void print11(int row,int col){
    if(row<=0){
      return ;
    }
    print12(col);
    System.out.println();
    print11(row-1, col);

  }
  static void print22(int  col,int n){
    if(col<=0){
      return ;
    }
    if(col==1||col==n)
    System.out.print("*");
    else
    System.out.print(" ");
    print22(col-1,n);

  }

  static void print21(int row,int col,int n){
    if(row<=0){
      return ;
    }
    if(row==1 || row==n)
    print12(col);
    else
    print22(col,n);
    System.out.println();
    print21(row-1, col,n);

  }
  static void print31(int row,int col){
    if(row<=0){
      return;
    }
    print31(row-1, col-1);
    System.out.println();
    print12(col);
  }
  static void print41(int row,int col){
    if(row<=0){
      return;
    }
    print12(col);
    System.out.println();
    print41(row-1, col-1);
  }


  static void print52(int  col){
    if(col<=0){
      return ;
    }
    System.out.print(" ");
    print52(col-1);
  }

  static void print51(int row,int col,int n){
    if(row<=0){
      return;
    }
    print51(row-1, col-1,n);
    print52(col-1);
    print12(n);
    System.out.println();
  }

static void print61(int row,int col,int n){
    if(row<=0){
      return;
    }
    print52(col-1);
    print12(n);
    System.out.println();
    print61(row-1, col-1,n);
  }



  public static void main(String[] args) {
    print11(5, 5);
    print21(5, 5, 5);
   // print31(5, 5);
  //  print41(4, 4);
    // print51(5, 5, 5);
   //  print61(5,5,5);

  }
}
 