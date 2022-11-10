package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidation {

    @Test
    void inputValidation() {
        assertThatThrownBy(() -> Util.isValidInput("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidInput("1401"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidInput("안녕"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());

        assertThatThrownBy(() -> Util.isValidInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
    }
}
