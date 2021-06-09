import java.lang.Math;

public class FizzBuzz{

  public static String fizzBuzz(Integer number) {
      if (number%3==0 && number%5==0){
          String str3="FizzBuzz";
          return str3;
      }
      else if (number%3==0) {
        String strone="Fizz";
        return strone;
      }
      else if (number%5==0) {
        String strtwo = "Buzz";
        return strtwo;
      }
      else {
          String str4="False";
          return str4;
      }
  }
    

    public static void main (String[] args) {
        String x =fizzBuzz(15);
        System.out.println(x);
  }
}