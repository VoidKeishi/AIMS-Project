import java.util.Scanner;
public class NumberOfDays{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a month: ");
        String strMonth = keyboard.nextLine();
        System.out.println("Enter a year: ");
        int iYear = keyboard.nextInt();
        int iDays = 0;
        boolean bLeapYear = false;
        switch (strMonth.toLowerCase()) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                iDays = 31;
                break;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                if (iYear % 4 == 0) {
                    if (iYear % 100 == 0) {
                        if (iYear % 400 == 0) {
                            bLeapYear = true;
                        }
                    } else {
                        bLeapYear = true;
                    }
                }
                if (bLeapYear) {
                    iDays = 29;
                } else {
                    iDays = 28;
                }
                break;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                iDays = 31;
                break;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                iDays = 30;
                break;
            case "may":
            case "5":
                iDays = 31;
                break;
            case "june":
            case "jun":
            case "6":
                iDays = 30;
                break;
            case "july":
            case "jul":
            case "7":
                iDays = 31;
                break;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                iDays = 31;
                break;
            case "september":
            case "sept.":
            case "sep":
            case "9":
                iDays = 30;
                break;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                iDays = 31;
                break;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                iDays = 30;
                break;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                iDays = 31;
                break;
            default:
                System.out.println("Invalid month!");
                break;
        }
        if (iDays != 0) {
            System.out.println("Number of days: " + iDays);
        }
        keyboard.close();
    }
}