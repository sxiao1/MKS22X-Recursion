public class recursion{
  public static double sqrt(double n, double tolerance){
    return sqrt2(n, 1, tolerance); //using helper function
  }
  public static double sqrt2(double n, double guess, double tolerance){
    double error = tolerance / 0.01; //changing percent error into decimal
    if(n == 0){
      return 0;
    }
    if((Math.abs((guess * guess) - n) / n) > tolerance){ //if more than wanted percent error
      return sqrt2(n, ( n / guess + guess) / 2, tolerance); //recurse through
    }
    return guess;
  }
  public static int fib(int n){
    return fib2(n, 0, 1); //calling helper function
  }
  public static int fib2(int n, int x, int y){
    if(n == 0){
      return x;
    }
    if(n == 1){
      return y;
    }
    return fib2(n -1, y, x +y);
  }
}
