import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
class PuzzleJava{
    public static int sumArrey(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];  
        }
        return sum;
    }
    public static void greatherThan(int[] arr){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
        if(arr[i]>10){
            myArray.add(arr[i]);
        }    
        }
    System.out.println(myArray);
    }
   public static void printName(){
       ArrayList<String> name = new ArrayList<String>();
       ArrayList<String> array = new ArrayList<String>();
       name.add("Nancy");
       name.add("Jinichi");
       name.add("Fujibayashi");
       name.add("Momochi");
       name.add("Ishikawa");
       Collections.shuffle(name);
       System.out.println(name);
       for(int i=0;i<name.size();i++){
        if (name.get(i).length() > 5) {
        array.add(name.get(i));}
    }
    System.out.println(array);
   } 
   public static void letter(){
       ArrayList<Character>letters=new ArrayList<Character>();
       letters.add('a');
       letters.add('b');
       letters.add('c');
       letters.add('d');
       letters.add('f');
       letters.add('g');
       letters.add('h');
       letters.add('i');
       letters.add('j');
       letters.add('k');
       letters.add('l');
       letters.add('m');
       letters.add('n');
       letters.add('o');
       letters.add('p');
       letters.add('q');
       letters.add('r');
       letters.add('s');
       letters.add('t');
       letters.add('u');
       letters.add('v');
       letters.add('w');
       letters.add('x');
       letters.add('y');
       letters.add('z');
       Collections.shuffle(letters);
        System.out.println(letters);
        System.out.println("last letter: "+letters.get(letters.size()-1));
        System.out.println("first letter: "+letters.get(0));
        if(letters.get(0)=='a' || letters.get(0)=='i' || letters.get(0)=='u' || letters.get(0)=='e' || letters.get(0)=='o'){
            System.out.println("first letter in the ArrayList is a vowel");
        }
   }
   public static void randomNumbers() {
        Random r = new Random();
        ArrayList<Integer>ran=new ArrayList<Integer>();
        for(int i=0;i<10;i++){
        ran.add(r.nextInt(100-55)+55);
        }
        System.out.println(ran);
        Collections.sort(ran);
        System.out.println(ran);
        System.out.println("Minimum value: "+Collections.min(ran)+", Maximum value: "+Collections.max(ran));
   }
   public static void randomString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(5);
        ArrayList<String>ranstring=new ArrayList<String>();
        for(int j=0;j<10;j++){
        for (int i = 0; i < 5; i++) {
            int index= (int)(AlphaNumericString.length()* Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        ranstring.add(sb.toString());
        sb.setLength(0);  
        }
        System.out.println(ranstring); 
   }
public static void main(String[] args){
    int[] arr={3,5,1,2,7,9,8,13,25,32};
    System.out.println(sumArrey(arr));
    greatherThan(arr);
    printName();
    letter();
    randomNumbers();
    randomString();
}
}