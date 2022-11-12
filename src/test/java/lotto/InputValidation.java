package lotto;

import lotto.enums.ErrorMessage;
import lotto.util.ValidationUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidation {

    @Test
    void inputAmountTest() {
        assertThatThrownBy(() -> ValidationUtil.isValidAmount("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidAmount("1401"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidAmount("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidAmount("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_INPUT.getValue());
    }

    @Test
    void inputWinNumberTest() {
        ValidationUtil.isValidWinNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,2,3,4,#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,2,3,4,-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1.2.3,4,-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WIN_NUMBERS_INPUT.getValue());

        assertThatThrownBy(() -> ValidationUtil.isValidWinNumbers("1,2,3,4,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER.getValue());
    }
}
