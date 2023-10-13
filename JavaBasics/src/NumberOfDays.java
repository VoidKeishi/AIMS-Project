// Write a program to display the number of days of a month, which is entered by users
// (both month and year). If it is an invalid month/year, ask the user to enter again.
// Note: You must create a new Java project for this exercise.
// - The user can either enter a month in its full name, abbreviation, in 3 letters, or in number.
// To illustrate, the valid inputs of January are January, Jan., Jan, and 1.
// - The user must enter a year in a non-negative number and enter all the digits. For instance,
// the valid input of year 1999 is only 1999, but not 99, “one thousand nine hundred
// ninety-nine”, or anything else.
// - A year is either a common year of 365 days or a leap year of 366 days. Every year that is
// divisible by 4 is a leap year, except for years that are divisible by 100, but not by 400. For
// instance, the year 1800 is not a leap year, yet the year 2000 is a leap year. In a year, there
// are twelve months, which are listed in order as follows.

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