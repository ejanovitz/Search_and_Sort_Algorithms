/*
 Search / Sort Algorithms
 Grade 12 High School Assignment
 Ethan Janovitz
 May 29, 2022
 */


package com.outlook.ejanovitz;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        String fileName = "Search.dat";
        int [] readInNums = new int[10000001];
        int index = 0;

        //int result = binarySearch(nums, 4);

        try{
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));

            while (in.available() > 0){
                index++;
                readInNums[index] = in.readInt();
            }

            linearSearch(readInNums);
            //System.out.println(binarySearch(readInNums));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void linearSearch(int[] readInNums){

        boolean found = false;
        long endTime = 0;
        long startTime = System.nanoTime();
        for(int i = 0; i < readInNums.length; i++) {
            if (readInNums[i] == 1066 ) {
                endTime = System.nanoTime();
                System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
                System.out.println("Execution time in milliseconds: " + ((endTime - startTime) / 1000000.0));
                System.out.println("Index found at - " + i);
                found = true;
                break;
            }
        }
        endTime = System.nanoTime();

        if (!found) {
            System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
            System.out.println("Execution time in milliseconds: " + ((endTime - startTime) / 1000000.0));
            System.out.println("Target number not in file");
        }
    }

    public static int binarySearch(int[] readInNums){
        int lower = 0;
        int upper = readInNums.length -1;
        int currentlySelected = (upper + lower)/2;
        int target = 1066;

        while (upper >= lower){

            if (readInNums[currentlySelected] < target){
                lower = currentlySelected +1;
            }else if (readInNums[currentlySelected] > target){
                upper = currentlySelected -1;
            }else{
                return currentlySelected;
            }
            currentlySelected = (upper + lower)/2;

            if(upper < lower){
                currentlySelected = -1;
            }
        }

        return currentlySelected;
    }
}