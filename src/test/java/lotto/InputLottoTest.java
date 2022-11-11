package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputLottoTest {

    @DisplayName("String to int")
    @Test
    void toLongs() {
        InputLotto inputLotto = new InputLotto();
        assertEquals(3000000000L,inputLotto.toLongs("3000000000"));
    }
}