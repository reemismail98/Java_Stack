import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava{
  public static void PrintOneto255(){
        for(int i=1;i<=255;i++){
        System.out.println(i);      
}}
public static void PrintOddNumber(){
  int sum =0;
      for(int i=1;i<=255;i++){
      if(i%2 != 0){
      System.out.println(i);
}
  }}
public static void sumNumber(){
   int sum =0;
  for(int i=0;i<=255;i++){
  sum+=i;
  System.out.println("New number:"+ i+ " Sum:"+ sum);      
}
}
public static void iteratingArry(){
    int []arr= {1,3,5,7,9,13};
    for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}
}
public static int findMax(){
int [] arr ={-3,-5,-7,0,6};
        int max=0;
        for(int i=0;i<arr.length;i++){
        if(max < arr[i]){
          max=arr[i];  
        }  
        }
        return max;
    }
public static void getAvg()
    {
      int[] arr={2,10,3,8,2};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];}
            double avg=  (double) sum/arr.length;
            System.out.println(avg);
    }
public static void oddNumber(){
  ArrayList<Integer> myArray = new ArrayList<Integer>();       
        int i=1;
        while(i<=255){
        myArray.add(i);
            i=i+2;
        }
       System.out.println(myArray);
}
public static int greaterThanY(int[] arr2,int y)
    {
        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(y<arr2[i]){
              count++;  
            }
    }
      return count;  
    }
public static void SquareValue(){
  int[] arr={1,3,4,5};
  for(int i=0;i<arr.length;i++){
  arr[i]=arr[i]*arr[i];}
  System.out.println(Arrays.toString(arr));
} 
public static void eliminateNwgatine(){
 int[] arr={1, 5, 10, -2};
  for(int i=0;i<arr.length;i++){
          if(arr[i]<0){
              arr[i]=0;
          }}
System.out.println(Arrays.toString(arr));
}
public static void MaxMinAverage(int[] arr2) {
  int min=0;
  int max=0;
  int sum=0;
  double avg=0;
    for(int i=0;i<arr2.length;i++){
        if(arr2[i]<min){
            min=arr2[i];
        }
        if(arr2[i]>max){
            max=arr2[i];
        }
       sum+=arr2[i];
       avg=(double) sum/arr2.length;
    }
		System.out.println(max);
		System.out.println(min);
		System.out.println(avg);
	}
public static void ShiftingValue(int[] arr2) {
      for(int i=0;i<arr2.length-1;i++){
          arr2[i]=arr2[i+1];
      }
      arr2[arr2.length-1]=0;
  System.out.println(Arrays.toString(arr2));
  		
  	}
public static void main (String[] args) {
  PrintOneto255();
  PrintOddNumber();
  sumNumber();
  iteratingArry();
  System.out.println(findMax());
  int[] arr={2,10,3,8,1};
  getAvg();
  oddNumber();
 int[] arr2={1, 3,4, 5, 7};
 int y=3;
 System.out.println(greaterThanY(arr2,y));
 SquareValue();
 eliminateNwgatine();
 MaxMinAverage(arr2);
 ShiftingValue(arr2);
  }
}

  
  



  




