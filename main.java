import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

class Lab5 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int[] input_arr = new int[16];
        System.out.println("Enter numbers (use spaces and/or commas): ");

        /*https://www.geeksforgeeks.org/java/how-to-take-array-input-from-user-in-java*/
        
        String usr_in = sc.nextLine();

        usr_in = usr_in.replace(" ", "@");
        usr_in = usr_in.replace(",", "@");
        String [] usr_in_split = usr_in.split("@"); 

        int i = 0;
        for (String s: usr_in_split) {
             if (s == "" || i > 15) continue;
             input_arr[i++] = Integer.parseInt(s);
        }

        System.out.println(Arrays.toString(arr));
        
                  


    }

    // Merges two integer arrays using Java Streams
    public static int[] mergeArraysUsingStreams(int[] arr1, int[] arr2) {

        // Convert both arrays into IntStreams and concatenate them
        return IntStream.concat(
                Arrays.stream(arr1),
                Arrays.stream(arr2)
        ).toArray(); // Convert the merged stream back to int[]
    }


    public static int[] rec_sort(int[] rec_array){
            if (rec_array.length == 1) return rec_array;
            
            int[] left_arr = Arrays.copyOfRange(rec_array, 0, (rec_array.length-1) >> 1);
            int[] right_arr = Arrays.copyOfRange(rec_array, (rec_array.length-1) >> 1, rec_array.length-1);
            
            //small optimization i stumbled on
            if (left_arr[left_arr.length-1] < right_arr[0]){
                return mergeArraysUsingStreams(left_arr, right_arr);
            }
            if (right_arr[right_arr.length-1] < left_arr[0]){
                return mergeArraysUsingStreams(right_arr, left_arr);
            }
            
            for (int i=j=0; j < left_arr.length != j || right_arr.length != i; ){
                
            }
             

    }


}
