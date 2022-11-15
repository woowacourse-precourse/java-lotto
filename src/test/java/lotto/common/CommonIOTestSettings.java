package lotto.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CommonIOTestSettings {

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

    protected void setTestInput(String testInput) {
        InputStream testIn = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(testIn);
    }
}
