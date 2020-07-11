package interestcalculator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test script for: InterestCalculator class")
public class InterestCalculatorTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private void clearOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void TC1() {
        provideInput("1\n2500\n1\nn\n");

        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Interest gained is"));

        clearOutput();

        provideInput("2\n2500\n40\n30\nn\n");

        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Interest gained is"));

        clearOutput();

        provideInput("3\n2500\n40\n30\nn\n");

        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Interest gained is"));

        clearOutput();

        provideInput("4\nn\n");

        InterestCalculator.main(null);

        assertTrue(getOutput().contains("DO YOU WANT TO CALCULATE AGAIN ????"));
    }

    @Test
    public void TC2() {
        provideInput("5\nn\n");

        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Wrong choice"));
    }

    @Test
    public void TC3() {
        provideInput("4\ny\n5\nn\n");

        InterestCalculator.main(null);

        assertEquals(2, StringUtils.countMatches(getOutput(),"SELECT THE OPTIONS"));

        clearOutput();

        provideInput("5\nn\n");

        InterestCalculator.main(null);

        assertEquals(1, StringUtils.countMatches(getOutput(),"SELECT THE OPTIONS"));
    }

    @Test
    public void TC4() {
        provideInput("3\n2500\n40\n30\nn\n");

        InterestCalculator.main(null);

        assertFalse(getOutput().contains("Enter only numbers"));
    }

    @Test
    public void TC5() {
        provideInput("T\n");
        InterestCalculator.main(null);

        assertTrue(getOutput().contains("You need to enter a number !"));

        clearOutput();

        provideInput("1\nG\n2500\n1\nn");
        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Enter only numbers :"));

        clearOutput();

        provideInput("2\nt\n2500\n40\n30\nn");
        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Enter only numbers :"));

        clearOutput();

        provideInput("3\ng\n2500\n40\n30\nn");
        InterestCalculator.main(null);

        assertTrue(getOutput().contains("Enter only numbers :"));
    }
}
