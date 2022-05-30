package com.outlook.ejanovitz;

import java.io.*;

public class Sort4 {

    public static void main(String[] args){
        String fileName = "Sort4.dat";
        int[] nums = new int[250001];
        int[] backup = nums.clone();
        int index = 0;


        try {
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));

            while(in.available() > 0){
                index++;
                nums[index] = in.readInt();
            }



            bubbleSort(nums);
            selectionSort(nums);
            insertionSort(nums);

            long endTime;
            long startTime = System.nanoTime();
            mergeSort(nums);
            endTime = System.nanoTime();
            System.out.println("\n---MERGE SORT---");
            System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
            System.out.println("Execution time in milliseconds: " + ((endTime - startTime) / 1000000.0));
            System.out.println("\nSORTED");

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int[] revert(int[] nums, int[] backup){
        for(int i = 0; i < nums.length - 1; i++){
            nums[i] = backup[i];
        }
        return nums;
    }

    public static void bubbleSort(int[] nums){

        int[] tempNums = nums.clone();
        int temp;
        long endTime;
        long startTime = System.nanoTime();

        for(int i = 0; i < tempNums.length -1; i ++){
            for(int x = 0; x < tempNums.length - 1; x++){
                if(tempNums[x] > tempNums[x + 1]){
                    temp = tempNums[x];
                    tempNums[x] = tempNums[x+1];
                    tempNums[x+1] = temp;
                }
            }
        }

        endTime = System.nanoTime();
        System.out.println("\n---BUBBLE SORT---");
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        System.out.println("Execution time in milliseconds: " + ((endTime - startTime) / 1000000.0));
        System.out.println("\nSORTED");
        System.out.println("20000th element is " + tempNums[20000]);
    }

    public static void selectionSort(int[] nums){

        int[] tempNums = nums.clone();
        long endTime;
        long startTime = System.nanoTime();
        for (int i = 0; i < tempNums.length - 1; i++) {

            int min = i;
            for (int j = i+1; j < tempNums.length; j++) {
                if (tempNums[j] < tempNums[min]) {
                    min = j;
                }
            }

            int temp = tempNums[min];
            tempNums[min] = tempNums[i];
            tempNums[i] = temp;
        }

        endTime = System.nanoTime();
        System.out.println("\n---SELECTION SORT---");
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        System.out.println("Execution time in milliseconds: " + ((endTime - startTime) / 1000000.0));
        System.out.println("\nSORTED");
        System.out.println("20000th element is " + tempNums[20000]);
    }

    public static void insertionSort(int[] nums){

        int[] tempNums = nums.clone();
        long endTime;
        long startTime = System.nanoTime();
        for(int i = 0; i < tempNums.length; i++){
            int tracker = tempNums[i];
            int j = i - 1;

            while(j >= 0 && tempNums[j] > tracker){
                tempNums[j + 1] = tempNums[j];
                j = j -1;
            }

            tempNums[j + 1] = tracker;
        }

        endTime = System.nanoTime();
        System.out.println("\n---INSERTION SORT---");
        System.out.println("Execution time in nanoseconds: " + (endTime - startTime));
        System.out.println("Execution time in milliseconds: " + ((endTime - startTime) / 1000000.0));
        System.out.println("\nSORTED");
        System.out.println("20000th element is " + tempNums[20000]);
    }

    public static void mergeSort(int[] nums) {
        int[] tempNums = nums.clone();

        int arrayLength = tempNums.length;

        if (arrayLength <= 1) {
            return;
        }
        int mid = arrayLength / 2;
        int[] left = new int[mid];
        int[] right = new int[arrayLength - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for (int i = mid; i < arrayLength; i++) {
            right[i - mid] = nums[i];
        }
        mergeSort(left);
        mergeSort(right);

        merge(nums, left, right, mid, arrayLength - mid);
    }

    public static void merge(int[] nums, int[] leftArray, int[] rightArray, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            }
            else {
                nums[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            nums[k++] = leftArray[i++];
        }
        while (j < right) {
            nums[k++] = rightArray[j++];
        }
    }
}

