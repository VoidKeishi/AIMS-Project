import java.util.Scanner;
public class AddMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Dimensions of the matrices");
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();
        double[][] matrix1 = new double[rows][columns];
        double[][] matrix2 = new double[rows][columns];

        System.out.println("Enter the first matrix: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++)
                matrix1[i][j] = input.nextDouble();
        }

        System.out.println("Enter the second matrix:");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++)
                matrix2[i][j] = input.nextDouble();
        }

        double[][] sum = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
        System.out.println("The sum of the 2 matrices is:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++)
                System.out.print(sum[i][j] + " ");
            System.out.println();
        }
    }
}