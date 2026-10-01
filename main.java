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

        System.out.println(Arrays.toString(input_arr));
        int[] sized_input_arr = new int[i+1];
        for (i = 0; i+1 < sized_input_arr.length; i++) sized_input_arr[i] = input_arr[i];

        System.out.println(Arrays.toString(sized_input_arr));

        int [] result = rec_sort(sized_input_arr); 

        System.out.println(Arrays.toString(result));
                  
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

            int[] ret_arr = new int[left_arr.length + right_arr.length];
            
            for (int left_arr_i = 0, right_arr_i = 0, ret_arr_i = 0; left_arr.length != left_arr_i || right_arr.length != right_arr_i; ){
                if (left_arr[left_arr_i] > right_arr[right_arr_i]) ret_arr[ret_arr_i++] = left_arr[left_arr_i++];
                else ret_arr[ret_arr_i++] = right_arr[right_arr_i++];
            }
            return ret_arr; 

    }


}
