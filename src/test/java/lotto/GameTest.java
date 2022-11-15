package lotto;

import lotto.check.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    @DisplayName("구매할 로또 금액이 1000단위가 아닌경우")
    @Test
    void 단위_테스트(){
        String input = "100";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isCashUnit(input));
    }

    @DisplayName("구매할 로또 금액이 숫자가 아닌 경우")
    @Test
    void 숫자_체크(){
        String input = "1jf3";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.isInputNumber(input));
    }
}
