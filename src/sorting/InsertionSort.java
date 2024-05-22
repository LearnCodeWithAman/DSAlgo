package sorting;

public class InsertionSort {

    public static void main(String args[]) {

        int[] arr = {8,84,3,32,9,17,11};
        int min=0, temp=0;

        for(int i=1; i<arr.length ; i++) {

            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        System.out.println("Insertion Sort : ");
        for(int i=0; i<arr.length; i++)
            System.out.print(" "+ arr[i]);
    }
}
