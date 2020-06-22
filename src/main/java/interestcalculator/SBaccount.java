package interestcalculator;


import java.util.Scanner;

class SBaccount extends Account {
    double SBamount , SbInterestRate, interest;
    Scanner SBScanner = new Scanner(System.in);

    @Override
    double calculateInterest(double amount){
        this.SBamount = amount;
        System.out.println("Select account type \n1. NRI \n2. Normal ");
        int accountChoice = 0;
        for (;;) {
            if (!SBScanner.hasNextInt()) {
                System.out.println("Enter only numbers : ");
                SBScanner.next(); // discard
                continue;
            }
            accountChoice = SBScanner.nextInt();
            break;
        }
        switch (accountChoice) {
            case 1:
                SbInterestRate = .06;
                break;
            case 2:
                SbInterestRate = .04;
                break;
            default:
                System.out.println("Please choose right account again");

        }
     return amount * SbInterestRate;

}
}
