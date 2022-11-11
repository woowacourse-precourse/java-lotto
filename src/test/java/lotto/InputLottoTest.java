package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputLottoTest {

    @DisplayName("String to int")
    @Test
    void toLongs() {
        InputLotto inputLotto = new InputLotto();
        assertEquals(3000000000L, inputLotto.toLongs("3000000000"));
    }

    @DisplayName(",(쉼표)를 기준으로 나누어 반환하는 메서드")
    @Test
    void splitCommas() {
        InputLotto inputLotto = new InputLotto();
        assertEquals(List.of("23", "42", "12", "3", "24", "26"), inputLotto.splitCommas("23,42,12,3,24,26"));
    }
}