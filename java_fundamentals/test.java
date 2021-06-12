public class BasicJava{
  public static void squareValue(int[] arr){
    for(int i=0;i<arr.length;i++){
      arr[i]=arr[i]*arr[i];}
      System.out.println(arr);  }
  public static void main (String[] args) {
      int[] arr={1,3,4,5};
      squareValue(arr);
}}