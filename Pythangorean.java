import java.lang.Math;

public class Pythangorean{

  public static double calculateHypotenuse(int legA, int legB) {
      // calling the sqrt static method of the Math class
    return Math.sqrt(legA*legA + legB*legB);
  }

  public static void main(String[] args) {
    int a = 4;
    int b = 9;
    double c = calculateHypotenuse(a, b);
    System.out.println(String.format("%.2f", c));
  }
}