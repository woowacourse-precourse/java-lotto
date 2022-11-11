package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputLottoTest {

    @DisplayName("String to int")
    @Test
    void toInts() {
        InputLotto inputLotto = new InputLotto();
        assertEquals(3,inputLotto.toInts("3"));
    }
}