import java.util.Scanner;
import java.util.Arrays;
public class SortAndCalculate {
    public static void main(String[] args){
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = input.nextInt();
        double[] numbers = new double[n];
        System.out.println("Enter the array elements:");
        for(int i = 1; i <= n; i++){
            System.out.print("number " + i + " = ");
            numbers[i-1] = input.nextDouble();
        }
        java.util.Arrays.sort(numbers);
        System.out.println("Sorted array:");
        for(int i = 0; i < n; i++){
            System.out.print(numbers[i] + " ");
        }
        double sum = Arrays.stream(numbers).sum();
        System.out.println("\nSum: " + sum);
        double average = sum / n;
        System.out.println("Average of the array elements: " + average);
    }
}
