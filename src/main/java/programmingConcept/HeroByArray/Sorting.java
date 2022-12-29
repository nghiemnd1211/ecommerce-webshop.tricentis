package programmingConcept.HeroByArray;

public class Sorting {

    public static void sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 4, 7, 2, 9, 5, 1};
        System.out.println("BEFORE SORTING...");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nAFTER SORTING...");
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
