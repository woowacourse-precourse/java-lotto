package lotto;

import lotto.exception.NonNumberFailure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

public class PreInputBridgeTest {


    @Test
    void if_input_not_number() {
        try {
            PreInput.checkInput("123!");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("[ERROR]"));
        }
    }

    @Test
    void if_input_blank() {
        try {
            PreInput.checkInput("123 ");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("[ERROR]"));
        }
    }
}
