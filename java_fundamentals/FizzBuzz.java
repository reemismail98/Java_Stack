import java.lang.Math;

public class Main{

  public static String fizzBuzz(int number) {
      String str= number +"";
      if (number%3==0 && number%5==0){
           str="FizzBuzz";
      }
      else if (number%3==0) {
         str="Fizz";
      }
      else if (number%5==0) {
         str = "Buzz";
      }
     return str;
  }
    

    public static void main (String[] args) {
        String x =fizzBuzz(15);
        System.out.println(x);
  }
}