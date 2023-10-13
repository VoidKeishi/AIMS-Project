import java.util.Scanner;
public class TriangleDisplay{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int n = keyboard.nextInt();
        for (int i = 1; i <= n; i++) {
            // Print spaces to align the stars to form a right-angled triangle
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print the stars for the current row
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            // Move to the next line for the next row
            System.out.println();
        }
    }
}