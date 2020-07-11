package interestcalculator;

import java.util.*;

public class FDaccount extends Account{
	double FDinterestRate;
    double FDAmount;
    int noOfDays;
    int ageOfACHolder;
    double General, SCitizen;
    Scanner FDScanner;

    public FDaccount(Scanner sc) {
        FDScanner = sc;
    }

    @Override
    double calculateInterest(double amount){
        this.FDAmount = amount;

        System.out.println("Enter FD days");
        for (;;) {
            if (!FDScanner.hasNextInt()) {
                System.out.println("Enter only numbers : ");
                FDScanner.next(); // discard
                continue;
            }
            noOfDays = FDScanner.nextInt();
            break;
        }

        System.out.println("Enter FD age holder ");
        for (;;) {
            if (!FDScanner.hasNextInt()) {
                System.out.println("Enter only numbers : ");
                FDScanner.next(); // discard
                continue;
            }
            ageOfACHolder = FDScanner.nextInt();
            break;
        }

        if (amount < 10000000) {
            if (noOfDays >= 7 && noOfDays <= 14) {
                General = 0.0450;
                SCitizen = 0.0500;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                General = 0.0470;
                SCitizen = 0.0525;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                General = 0.0550;
                SCitizen = 0.0600;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                General = 0.0700;
                SCitizen = 0.0750;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                General = 0.0750;
                SCitizen = 0.0800;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                General = 0.0800;
                SCitizen = 0.0850;
            }
            FDinterestRate = (ageOfACHolder < 50) ? General : SCitizen;
        } else {
            if (noOfDays >= 7 && noOfDays <= 14) {
                interestRate = 0.065;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                interestRate = 0.0675;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                interestRate = 0.00675;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                interestRate = 0.080;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                interestRate = 0.0850;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                interestRate = 0.10;
            }

        }

        return FDAmount * FDinterestRate;
    }
}

