//Реализовать алгоритм пирамидальной сортировки (HeapSort).
package Work005;
import java.util.Arrays;
import java.util.Scanner;

public class Task003 {
    public static void main(String[] args) {
        Scanner userInput;
        String[] rawData;
        boolean badInput = true;
        Integer[] inputData = new Integer[0];
        Integer[] outputData;

        while (badInput) {
            badInput = false;
            System.out.println("Enter an array of numbers, separated by a SPACE: ");
            userInput = new Scanner(System.in);
            rawData = userInput.nextLine().split(" ");
            inputData = new Integer[rawData.length];
            try {
                for (int i = 0; i < rawData.length; i++) {
                    inputData[i] = Integer.valueOf(rawData[i]);
                }
                badInput = false;
            } catch (Exception e) {
                System.out.println("Incorrect input");
                badInput = true;
            }
        }
        System.out.printf("Entered array of numbers: %s \n", Arrays.toString(inputData));
        outputData = HeapSort(inputData);
        System.out.printf("Array of numbers after sorting: %s \n", Arrays.toString(outputData));
    }

    public static Integer[] HeapSort(Integer[] arg) {
        for (int i = arg.length / 2 - 1; i >= 0; i--)
            arg = HeapForm(arg, arg.length, i);

        for (int i = arg.length - 1; i >= 0; i--)
        {
            int temp = arg[0];
            arg[0] = arg[i];
            arg[i] = temp;
            arg = HeapForm(arg, i, 0);
        }

        return arg;
    }

    public static Integer[] HeapForm(Integer[] arg, int size, int head) {
        int largest = head;
        int l = 2 * head + 1;
        int r = 2 * head + 2;

        if (l <size && arg[l] > arg[largest])
            largest = l;
        if (r < size && arg[r] > arg[largest])
            largest = r;

        if (largest != head)
        {
            int swap = arg[head];
            arg[head] = arg[largest];
            arg[largest] = swap;
            arg = HeapForm(arg, size, largest);
        }
        return arg;
    }
}
