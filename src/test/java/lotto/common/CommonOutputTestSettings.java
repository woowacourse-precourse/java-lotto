package lotto.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CommonOutputTestSettings {

    protected static ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    protected static PrintStream standardOut;

    @BeforeEach
    protected void initOutputStreamSettings() {
        testOut.reset();
        standardOut = System.out;
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    protected void printOutputStream() {
        System.setOut(standardOut);
        System.out.println(testOut.toString().trim());
    }
}
