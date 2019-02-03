public class recursion{
  public static double sqrt(double n, double tolerance){
    return sqrt2(n, 1, tolerance); //using helper function
  }
  public static double sqrt2(double n, double guess, double tolerance){
    double error = tolerance / 0.01;
    if(n == 0){
      return 0;
    }
    if((Math.abs((guess * guess) - n) / n) > tolerance){
      return sqrt2(n, ( n / guess + guess) / 2, tolerance);
    }
    else{
      return guess;
    }
  }
}
