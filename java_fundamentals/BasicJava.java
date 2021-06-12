// //1-Print 1-255
// import java.io.*;

// public class BasicJava{
//     public static void main (String[] args) {
//          for(int i=1;i<=255;i++){
//         System.out.println(i);       
      
// }

//   }
// }

// //2- Print odd numbers between 1-255

// import java.io.*;

// public class BasicJava{


//     public static void main (String[] args) {
//         int sum =0;
//         for(int i=1;i<=255;i++){
//       if(i%2 != 0){
//         System.out.println(i);
//     }
//   }}
// }

// //3-Print Sum

// public class BasicJava{
//   public static void main (String[] args) {
//       int sum =0;
//       for(int i=0;i<=255;i++){
//       sum+=i;
      
//        System.out.println("New number:"+ i+ " Sum:"+ sum);
          
//       }
// }
// }

// //4-Iterating through an array

// public class BasicJava{
//   public static void main (String[] args) {
//       int []arr= {1,3,5,7,9,13};
//       for(int i=0;i<arr.length;i++){
//        System.out.println(arr[i]);
//       }
// }
// }

// //5-Find Max

// public class BasicJava{
//     public static int findMax(){
// int [] arr ={-3,-5,-7,0,6};
//         int max=0;
//         for(int i=0;i<arr.length;i++){
//         if(max < arr[i]){
//           max=arr[i];  
//         }
       
            
//         }
//         return max;
//     }
//     public static void main (String[] args) {
        
//          System.out.println(findMax());
            
        
//   }
// }

// //6-Get Average

// public class BasicJava{
//     public static int getAvg(int[] arr)
//     {
//         int sum=0;
//         for(int i=0;i<arr.length;i++){
//             sum+=arr[i];}
//             int avg= (sum/arr.length);
//             return avg;
//     }
//   public static void main (String[] args) {
//       int[] arr={2, 10, 3};
       
//        System.out.println(getAvg(arr));
//       }
// }

//7-Array with Odd Numbers

// import java.util.ArrayList;  

// public class BasicJava{
// public static void oddNumber(){
//   ArrayList<Integer> myArray = new ArrayList<Integer>();       
//         int i=1;
//         while(i<=255){
//         myArray.add(i);
//             i=i+2;
//         }
      
//        System.out.println(myArray);
// }
//   public static void main (String[] args) {
//     oddNumber();
//       }
// }

//8-Greater Than Y


// public class BasicJava{
//     public static int greaterThanY(int[] arr,int y)
//     {
//         int count=0;
//         for(int i=0;i<arr.length;i++){
//             if(y<arr[i]){
//               count++;  
//             }
//     }
//       return count;  
//     }
//   public static void main (String[] args) {
//       int[] arr={1, 3,4, 5, 7};
//       int y=3;
//        System.out.println(greaterThanY(arr,y));
//       }
// }

// //9-Square the values**

// public class BasicJava{
//   public static void main (String[] args) {
//       int[] arr={1,3,4,5};
//       for(int i=0;i<arr.length;i++){
//       arr[i]=arr[i]*arr[i];}
//       System.out.println(arr);
// }}

//10-Eliminate Negative Numbers**
// public class BasicJava{

//   public static void main (String[] args) {
//             int[] arr={1, 5, 10, -2};
//   for(int i=0;i<arr.length;i++){
//           if(arr[i]<0){
//               arr[i]=0;
//           }}
//         System.out.println(arr);
// }}

// //11-Max, Min, and Average

// public class BasicJava{
// public static void MaxMinAverage(int[] arr) {
//   int min=0;
//   int max=0;
//   int sum=0;
//   double avg=0;
//     for(int i=0;i<arr.length;i++){
//         if(arr[i]<min){
//             min=arr[i];
//         }
//         if(arr[i]>max){
//             max=arr[i];
//         }
//        sum+=arr[i];
//        avg=(double) sum/arr.length;
//     }
// 		System.out.println(max);
// 		System.out.println(min);
// 		System.out.println(avg);
// 	}
//   public static void main (String[] args) {
//     int[] arr={1, 5, 10, -2};
// MaxMinAverage(arr);
// }}

// //12-Shifting the Values in the Array
public class BasicJava{
  public static void ShiftingValue(int[] arr) {
      for(int i=0;i<arr.length-1;i++){
          arr[i]=arr[i+1];
      }
      arr[arr.length-1]=0;
  		System.out.println(arr);
  		
  	}
    public static void main (String[] args) {
      int[] arr={1, 5, 10, 7, -2};
      ShiftingValue(arr);
  }}
  
  



  




