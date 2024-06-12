import java.util.Arrays;
import java.util.Scanner;

public class algorithmApplication {
    
    // Bubble Sort Implementation
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    // Quick Sort Implementation
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi-1);
            quickSort(array, pi+1, high);
        }
    }
    
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }
    
    // Linear Search Implementation
    public static int linearSearch(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }
    
    // Binary Search Implementation
    public static int binarySearch(int[] array, int x) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        System.out.println("Choose an algorithm type: \n1. Sorting \n2. Searching");
        int choice = scanner.nextInt();
        
        long startTime, endTime, duration;
        
        switch (choice) {
            case 1:
                System.out.println("Choose a sorting algorithm: \n1. Bubble Sort \n2. Quick Sort");
                int sortChoice = scanner.nextInt();
                switch (sortChoice) {
                    case 1:
                        startTime = System.nanoTime();
                        bubbleSort(array);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Sorted Array: " + Arrays.toString(array));
                        System.out.println("Bubble Sort Time Complexity: O(n^2)");
                        break;
                    case 2:
                        startTime = System.nanoTime();
                        quickSort(array, 0, array.length - 1);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Sorted Array: " + Arrays.toString(array));
                        System.out.println("Quick Sort Time Complexity: O(n log n)");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }
                System.out.println("Execution time (nanoseconds): " + duration);
                break;
                
            case 2:
                System.out.println("Choose a searching algorithm: \n1. Linear Search \n2. Binary Search");
                int searchChoice = scanner.nextInt();
                System.out.println("Enter the element to search:");
                int x = scanner.nextInt();
                
                switch (searchChoice) {
                    case 1:
                        startTime = System.nanoTime();
                        int linearResult = linearSearch(array, x);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        if (linearResult != -1) {
                            System.out.println("Element found at index: " + linearResult);
                        } else {
                            System.out.println("Element not found.");
                        }
                        System.out.println("Linear Search Time Complexity: O(n)");
                        break;
                    case 2:
                        startTime = System.nanoTime();
                        Arrays.sort(array);  // Binary search requires sorted array
                        int binaryResult = binarySearch(array, x);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        if (binaryResult != -1) {
                            System.out.println("Element found at index: " + binaryResult);
                        } else {
                            System.out.println("Element not found.");
                        }
                        System.out.println("Binary Search Time Complexity: O(log n)");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }
                System.out.println("Execution time (nanoseconds): " + duration);
                break;
                
            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
