/*

    <@'
    (KU//
     "

ROCK CHALK

EECS 210
BY LUCAS FRIAS
WEDNESDAY 8:00 AM (PARDAS)
LAB 05 - MERGE SORT
DESCRIPTION: A RECURSIVE
MERGE SORT FOR INTEGERS

*/



import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

class Lab5 {
    public static void main(String[] args){
        //ahhhh i love my public static void main string args
        //what a super simple language

        //make an input scanenr
        Scanner sc = new Scanner(System.in);
    
        //okay make our prompt scanner
        int[] input_arr = new int[16];
        //max input is 16 so our array is 16
        System.out.println("Enter numbers (use spaces and/or commas): ");

        /*https://www.geeksforgeeks.org/java/how-to-take-array-input-from-user-in-java*/
        
        String usr_in = sc.nextLine(); //get the whole line
        
        //transform usr_in into @ so we can parse way better with the split
        usr_in = usr_in.replace(" ", "@");
        usr_in = usr_in.replace(",", "@");
        String [] usr_in_split = usr_in.split("@"); //split

        int i = 0;//start an i counter len
        for (String s: usr_in_split) {
             if (s == "" || i > 15) continue;//this means the split has nothing else
             input_arr[i++] = Integer.parseInt(s);//otherwise lets parse it as an int
        }

        int[] sized_input_arr = new int[i];//now lets use our i as the new array
        //we "resize" the input array to be the size the user inputed and remove
        //bad extra characters
        for (i = 0; i < sized_input_arr.length; i++) sized_input_arr[i] = input_arr[i];
        
        //get our dynamic array result from recsort
        int [] result = rec_sort(sized_input_arr); 
        //print that guy out
        System.out.println(Arrays.toString(result));
                  
    }

    // Merges two integer arrays using Java Streams
    //from my buddies at geeksforgeeks
    //https://www.geeksforgeeks.org/java/java-program-to-merge-two-arrays/
    public static int[] mergeArraysUsingStreams(int[] arr1, int[] arr2) {

        // Convert both arrays into IntStreams and concatenate them
        return IntStream.concat(
                Arrays.stream(arr1),
                Arrays.stream(arr2)
        ).toArray(); // Convert the merged stream back to int[]
    }


    public static int[] rec_sort(int[] rec_array) {
        //this is pretty much just a textbook rec_sort with some
        //java-isms
        //base case
        if (rec_array.length <= 1)
            return rec_array;
        
        //git the middle of the array
        int mid = rec_array.length >> 1;

        //calculate left, right array space
        int[] left_arr = Arrays.copyOfRange(rec_array, 0, mid);
        int[] right_arr = Arrays.copyOfRange(rec_array, mid, rec_array.length);

        //recursively get what the sorted should be
        left_arr = rec_sort(left_arr);
        right_arr = rec_sort(right_arr);
        //make a new array with the combined size
        int[] ret_arr = new int[left_arr.length + right_arr.length];
        
        //make our three iterators
        int left_i = 0, right_i = 0, ret_i = 0;
        
        //while the left_i and right_i are still within bounds (loop together)
        while (left_i < left_arr.length && right_i < right_arr.length) {
            //do left stuff
            if (left_arr[left_i] < right_arr[right_i])
                ret_arr[ret_i++] = left_arr[left_i++];
            //otherwise do right stuff
            else
                ret_arr[ret_i++] = right_arr[right_i++];
        }
        //if one of left_i or right_i still has more elements
        //then we still loop through them
        while (left_i < left_arr.length)
            ret_arr[ret_i++] = left_arr[left_i++];

        while (right_i < right_arr.length)
            ret_arr[ret_i++] = right_arr[right_i++];
        //return the ret_arr
        return ret_arr;
    }


}
