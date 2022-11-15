package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

public abstract class CustomNsTest {
    private OutputStream captor;
    private PrintStream standardErr;

    @BeforeEach
    protected final void init() {
        standardErr = System.err;
        captor = new ByteArrayOutputStream();
        System.setErr(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setErr(standardErr);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void run(final String... args) {
        command(args);
        runMain();
    }

    protected final void runException(final String... args) {
        try {
            run(args);
        } catch (final RuntimeException error) {
            System.err.println(error);
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected abstract void runMain();
}


