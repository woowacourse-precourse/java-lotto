package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void validateException() {
        // GIVEN
        InputStream in = new ByteArrayInputStream("3001".getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        // WHEN AND THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            User user = new User();

        }) ;
    }
}