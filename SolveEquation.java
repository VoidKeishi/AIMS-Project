//2.2.6: SolveEquation
import java.util.Scanner;
public class SolveEquation{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose the type of equation you want to solve:");
        System.out.println("1. First degree equation with one variable");
        System.out.println("2. First degree equation with two variables");
        System.out.println("3. Second degree equation with one variable");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int choice = myObj.nextInt();
        switch(choice){
            case 1:
                solveFirstDegree();
                break;
            case 2:
                solveSystemFirstDegree();
                break;
            case 3:
                solveSecondDegree();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
        }
    }
    private static void solveFirstDegree(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        double a = myObj.nextDouble();
        System.out.println("Enter the value of b: ");
        double b = myObj.nextDouble();
        if(a == 0){
            if(b == 0){
                System.out.println("The solution is all x!");
            }else{
                System.out.println("No solution!");
            }
        }else{
            System.out.println("The solution is: " + -b/a);
        }
    }
    private static void solveSystemFirstDegree(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the value of a1: ");
        double a1 = myObj.nextDouble();
        System.out.println("Enter the value of b1: ");
        double b1 = myObj.nextDouble();
        System.out.println("Enter the value of c1: ");
        double c1 = myObj.nextDouble();
        System.out.println("Enter the value of a2: ");
        double a2 = myObj.nextDouble();
        System.out.println("Enter the value of b2: ");
        double b2 = myObj.nextDouble();
        System.out.println("Enter the value of c2: ");
        double c2 = myObj.nextDouble();
        double D, Dx, Dy;
        D = a1*b2 - a2*b1;
        Dx = c1*b2 - c2*b1;
        Dy = a1*c2 - a2*c1;
        if(D == 0){
            if(Dx + Dy == 0){
                System.out.println("The solution is all x and y!");
            }else{
                System.out.println("No solution!");
            }
        }
        else{
            System.out.println("The solution is: " + "x = " + Dx/D + " and " + "y = " + Dy/D);
        }
    }
    private static void solveSecondDegree(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        double a = myObj.nextDouble();
        System.out.println("Enter the value of b: ");
        double b = myObj.nextDouble();
        System.out.println("Enter the value of c: ");
        double c = myObj.nextDouble();
        double delta = b*b - 4*a*c;
        double x1, x2;
        if(delta > 0){
            x1 = (-b + Math.sqrt(delta))/(2*a);
            x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("The solution is: " + x1 + " and " + x2);
        }else if(delta == 0){
            x1 = (-b)/(2*a);
            System.out.println("The solution is: " + x1);
        }else{
            System.out.println("No solution!");
        }
    }
}