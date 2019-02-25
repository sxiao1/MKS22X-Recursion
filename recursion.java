import java.util.ArrayList;
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
  public static boolean closeEnough(double ans, double correct){
    return (Math.abs((ans - correct) / correct) <= 0.00001);
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
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> ary = new ArrayList<Integer>();
    makeAllSums1(n, 0, ary);
    return ary;
  }
  public static void makeAllSums1(int n, int x, ArrayList<Integer> ary){
    if(n == 0){
      ary.add(x);
    }
    else{
      makeAllSums1(n-1, x + n, ary);
      makeAllSums1(n-1, x, ary);
    }
  }
  //testcase must be a valid index of your input/output array
  public static void testFib(int testcase){
    recursion r = new recursion();
    int[] input = {0,1,2,3,5,30};
    int[] output ={0,1,1,2,5,832040};
    int max = input.length;
    if(testcase < input.length){
      int in = input[testcase];
      try{

        int ans = r.fib(in);
        int correct = output[testcase];
        if(ans == correct){
          System.out.println("PASS test fib "+in+". "+correct);
        }
        else{
          System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test fib"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }


  //testcase must be a valid index of your input/output array
  public static void testSqrt(int testcase){
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
      double in = input[testcase];
      try{

        double ans = r.sqrt(in,.00001);
        double correct = Math.sqrt(in);
        if(closeEnough(ans,correct)){
          System.out.println("PASS test sqrt "+in+" "+ans);
        }
        else{
          System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }
  public static String checker(int num){
    testFib(2);
    testSqrt(2);
    return "";
  }

}
