package interestcalculator;

import java.util.Scanner;

public class InterestCalculator {
    private static void calculateInterestSBaccount(Scanner sc) {
        SBaccount sb = new SBaccount();
        System.out.println("Enter the Average SB amount ");
        double amount = sc.nextDouble();
        System.out.println("Interest gained is : $ " + sb.calculateInterest(amount));
    }

    private static void calculateInterestFDaccount(Scanner sc) {
        FDaccount fd = new FDaccount();
        System.out.println("Enter the FD Amount");
        double fAmount = sc.nextDouble();
        System.out.println("Interest gained is: $ " + fd.calculateInterest(fAmount));
    }

    private static void calculateInterestRDaccount(Scanner sc) {
        RDaccount rd = new RDaccount();
        System.out.println("Enter the RD amount");
        double rAmount = sc.nextDouble();
        System.out.println("Interest gained is: $ " + rd.calculateInterest(rAmount));
    }

    private static void chooseAccount() {
        Scanner sc = new Scanner(System.in);
        char more;
        do {
            System.out.println("SELECT THE OPTIONS " + "\n1." + " Interest Calculator-SB" + " \n2." + " Interest Calculator-FD"
                    + "\n3." + " InterestCalculator-RD" + "\n4 " + " Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    calculateInterestSBaccount(sc);
                    break;
                case 2:
                    calculateInterestFDaccount(sc);
                    break;
                case 3:
                    calculateInterestRDaccount(sc);
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
    }

    public static void main(String[] args) {
        chooseAccount();
    }

}
