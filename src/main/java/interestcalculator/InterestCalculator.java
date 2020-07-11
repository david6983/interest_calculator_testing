package interestcalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterestCalculator {
    private static void enterAndComputeSBamount(Scanner sc) {
        SBaccount sb = new SBaccount(sc);
        System.out.println("Enter the Average SB amount ");
        double amount = -1;
        for (;;) {
            if (!sc.hasNextDouble()) {
                System.out.println("Enter only numbers : ");
                sc.next(); // discard
                continue;
            }
            amount = sc.nextDouble();
            break;
        }
        System.out.println("Interest gained is : $ " + sb.calculateInterest(amount));
    }

    private static void enterAndComputeFDaccount(Scanner sc) {
        FDaccount fd = new FDaccount(sc);
        System.out.println("Enter the FD Amount");
        double fAmount = -1;
        for (;;) {
            if (!sc.hasNextDouble()) {
                System.out.println("Enter only numbers : ");
                sc.next(); // discard
                continue;
            }
            fAmount = sc.nextDouble();
            break;
        }
        System.out.println("Interest gained is: $ " + fd.calculateInterest(fAmount));
    }

    private static void enterAndComputeRDaccount(Scanner sc) {
        RDaccount rd = new RDaccount(sc);
        System.out.println("Enter the RD amount");
        double rAmount = -1;
        for (;;) {
            if (!sc.hasNextDouble()) {
                System.out.println("Enter only numbers : ");
                sc.next(); // discard
                continue;
            }
            rAmount = sc.nextDouble();
            break;
        }
        System.out.println("Interest gained is: $ " + rd.calculateInterest(rAmount));
    }

    private static void chooseAccount() {
        Scanner sc = new Scanner(System.in);
        char more;
        try {
            do {
                System.out.println("SELECT THE OPTIONS " + "\n1." + " Interest Calculator-SB" + " \n2." + " Interest Calculator-FD"
                        + "\n3." + " InterestCalculator-RD" + "\n4 " + " Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        enterAndComputeSBamount(sc);
                        break;
                    case 2:
                        enterAndComputeFDaccount(sc);
                        break;
                    case 3:
                        enterAndComputeRDaccount(sc);
                        break;
                    case 4:
                        System.out.println("DO YOU WANT TO CALCULATE AGAIN ????" + " "
                                + "RUN AGAIN THE PROGRAM");
                    default:
                        System.out.println("Wrong choice");

                }
                System.out.println("WANA CONTINUE-(y for YES OR n for NO)");
                more = sc.next().charAt(0);
            } while(more=='y' || more=='Y');
        } catch(InputMismatchException err) {
            System.out.println("You need to enter a number !");
        }
    }

    public static void main(String[] args) {
        chooseAccount();
    }

}
