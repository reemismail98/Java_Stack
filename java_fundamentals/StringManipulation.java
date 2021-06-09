import java.io.*;

public class Main{

  public String trimAndConcat(String x, String y) {
      return (x.trim() + y.trim());
  }
  public Integer getIndex(String str, char letter){
      return str.indexOf(letter);
  }
  public Integer getIndexOrNull(String str, String substring){
      return str.indexOf(substring);
}
  public String concatSubstring(String str1, int i, int ii, String str2){
    String substr=str1.substring(i,ii);
    return substr+str2;
}
    public static void main (String[] args) {
        Main manipulator = new Main();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str); // HelloWorld 
        
        char letter = 'o';
        Integer a = manipulator.getIndex("Coding", letter);
        Integer b = manipulator.getIndex("Hello World", letter);
        Integer c = manipulator.getIndex("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c);
        
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer s = manipulator.getIndexOrNull(word, subString);
        Integer ss = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(s); // 2
        System.out.println(ss); // null

        String substring1 = manipulator.concatSubstring("Hello", 1, 4, "world");
        System.out.println(substring1); 


  }
}