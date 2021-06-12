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
       name.add("Nancy");
       name.add("Jinichi");
       name.add("Fujibayashi");
       name.add("Momochi");
       name.add("Ishikawa");
       Collections.shuffle(name);
       System.out.println(name);
    //    Random r = new Random();
    //    System.out.println(r.nextInt(5));
   } 
public static void main(String[] args){
    int[] arr={3,5,1,2,7,9,8,13,25,32};
    System.out.println(sumArrey(arr));
    greatherThan(arr);
    printName();
}
}