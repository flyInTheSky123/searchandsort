package com.person.search;

public class search {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9};

        System.out.println(biSearch(array,7)+": "+array[ biSearch(array,7)]);

    }

    public static int biSearch(int[] array,int value) {
        int low = 0;
        int high = array.length-1;
        int middle;

        while (low <= high) {
            middle = (low+high)/2;
           if (array[middle]==value){
               return middle;
           }
           if (array[middle]>value){
               high= middle-1;
           }else {
               low=middle+1;
           }

        }
        return -1;

    }
}
