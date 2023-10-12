//2.2.5: CalculateTwoNumbers
import javax.swing.JOptionPane;
public class CalculateTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";
        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        JOptionPane.showMessageDialog(null,num1+num2,"Sum", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,num1-num2,"Difference", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,num1*num2,"Product", JOptionPane.INFORMATION_MESSAGE);
        if (num2!=0){
            JOptionPane.showMessageDialog(null,num1/num2,"Quotient", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            String strError = "Error: Divide by zero";
            JOptionPane.showMessageDialog(null,strError,"Quotient error", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}