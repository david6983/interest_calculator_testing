package interestcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Test script for: RDaccount class")
public class RDaccountTest {
    private RDaccount rda;
    private DecimalFormat df2;

    private ByteArrayInputStream testIn;

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        rda.RDScanner = new Scanner(testIn);
    }

    @BeforeEach
    public void beforeEach() {
        rda = new RDaccount();
        df2 = new DecimalFormat("#.##");
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        rda.RDScanner = new Scanner(System.in);
    }

    @Test
    public void TC_01_001() {
        // we provide the user input by hand using a string:
        // first number is the month and the second number is the age
        // '\n' simulates 'Enter'
        provideInput("5\n25\n");
        assertEquals(df2.format(3.75), df2.format(rda.calculateInterest(50)));
    }

    @Test
    public void TC_01_002() {
        provideInput("5\n55\n");
        assertEquals(df2.format(4.00), df2.format(rda.calculateInterest(50)));
    }

    @Test
    public void TC_01_003() {
        provideInput("8\n30\n");
        assertEquals(df2.format(7.75), df2.format(rda.calculateInterest(100)));
    }

    @Test
    public void TC_01_004() {
        provideInput("8\n60\n");
        assertEquals(df2.format(8.25), df2.format(rda.calculateInterest(100)));
    }

    @Test
    public void TC_01_005() {
        provideInput("11\n35\n");
        assertEquals(df2.format(40.0), df2.format(rda.calculateInterest(500)));
    }

    @Test
    public void TC_01_006() {
        provideInput("11\n65\n");
        assertEquals(df2.format(42.5), df2.format(rda.calculateInterest(500)));
    }

    @Test
    public void TC_01_007() {
        provideInput("14\n40\n");
        assertEquals(df2.format(123.75), df2.format(rda.calculateInterest(1500)));
    }

    @Test
    public void TC_01_008() {
        provideInput("14\n70\n");
        assertEquals(df2.format(131.25), df2.format(rda.calculateInterest(1500)));
    }

    @Test
    public void TC_01_009() {
        provideInput("17\n45\n");
        assertEquals(df2.format(212.5), df2.format(rda.calculateInterest(2500)));
    }

    @Test
    public void TC_01_010() {
        provideInput("17\n75\n");
        assertEquals(df2.format(225.0), df2.format(rda.calculateInterest(2500)));
    }

    @Test
    public void TC_01_011() {
        provideInput("25\n45\n");
        assertEquals(df2.format(350), df2.format(rda.calculateInterest(4000)));
    }

    @Test
    public void TC_01_012() {
        provideInput("25\n80\n");
        assertEquals(df2.format(370), df2.format(rda.calculateInterest(4000)));
    }
}
