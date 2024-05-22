package sorting;

public class SelectionSort {

    public static void main(String args[]) {

        int[] arr = {8,32,84,3,9,17,11};
        int min;
        int temp;

        for(int i=0; i<arr.length-1; i++) {

            min = i;

            for(int j=i+1; j<arr.length; j++)
                if(arr[j] < arr[min])
                    min = j;

            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Selection Sort : ");
        for(int i=0; i<arr.length; i++)
            System.out.print(" "+ arr[i]);
    }
}
