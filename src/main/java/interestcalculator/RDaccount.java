package interestcalculator;

import java.util.Scanner;

public class RDaccount extends Account {

    double RDInterestRate;
    double RDamount;
    int noOfMonths;
    int age;
    double monthlyAmount;
    double General, SCitizen;
    Scanner RDScanner;

    public RDaccount(Scanner sc) {
        RDScanner = sc;
    }

    @Override
    double calculateInterest(double Ramount){
        this.RDamount = Ramount;
        System.out.println("Enter RD months");
        for (;;) {
            if (!RDScanner.hasNextInt()) {
                System.out.println("Enter only numbers : ");
                RDScanner.next(); // discard
                continue;
            }
            noOfMonths = RDScanner.nextInt();
            break;
        }

        System.out.println("Enter RD holder age");
        for (;;) {
            if (!RDScanner.hasNextInt()) {
                System.out.println("Enter only numbers : ");
                RDScanner.next(); // discard
                continue;
            }
            age = RDScanner.nextInt();
            break;
        }
        if (noOfMonths >= 0 && noOfMonths <= 6) {
            General = .0750;
            SCitizen = 0.080;
        } else if (noOfMonths >= 7 && noOfMonths <= 9) {
            General = .0775;
            SCitizen = 0.0825;
        } else if (noOfMonths >= 10 && noOfMonths <= 12) {
            General = .0800;
            SCitizen = 0.0850;
        } else if (noOfMonths >= 13 && noOfMonths <= 15) {
            General = .0825;
            SCitizen = 0.0875;
        } else if (noOfMonths >= 16 && noOfMonths <= 18) {
            General = .0850;
            SCitizen = 0.0900;
        } else if (noOfMonths >= 22) {
            General = .0875;
            SCitizen = 0.0925;
        }
        RDInterestRate = (age < 50) ? General : SCitizen;
        return RDamount * RDInterestRate;

    }

}
