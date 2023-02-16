package org.example;
import java.util.*;
//Array Reverse: Write a Java program that takes an array of integers and reverses its elements. Your program should prompt the user to enter the array size
// and the elements of the array, and then output the reversed array.
//Make HashMap from the result array and performs the following operations: a) Add a key-value pair to the map; b) Remove a key-value pair from the map;
// c) Check if a key is in the map; d) Find the value associated with a given key; e) Print all the keys and values in the map;
//Make up the situation for ArrayIndexOutOfBoundsException. Catch it and display the explanation for your custom case.
public class Main {
    public static void main(String[] args) {
        List reArr = reverseArr();
        HashMap arrayToMap = new HashMap();
        for(int j = 0; j < reArr.size(); j++){
            arrayToMap.put(j, reArr.get(j));
        }
        arrayToMap.put(50, 100);
        arrayToMap.remove(3);
        arrayToMap.containsKey(3);
        arrayToMap.get(2);
        System.out.println(arrayToMap.toString());

        try{
            int[] arr = new int[3];
            for(int k = 0; k < arr.length+1; k++){
                System.out.println(arr[k]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds exception");
        }
    }

    static List reverseArr(){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++){
            arr[i] = in.nextInt();
        }
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
        return Arrays.asList(arr);
    }
}