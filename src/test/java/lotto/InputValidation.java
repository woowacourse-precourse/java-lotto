package lotto;

import lotto.enums.ErrorMessage;
import lotto.util.Util;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidation {

    @Test
    void inputAmountTest() {

        assertThatThrownBy(() -> Util.isValidAmount("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidAmount("1401"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidAmount("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
    }

    @Test
    void inputWinNumberTest() {
        Util.isValidWinNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> Util.isValidWinNumbers("1,2,3,4,#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidWinNumbers("1,2,3,4,-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());
    }
}
