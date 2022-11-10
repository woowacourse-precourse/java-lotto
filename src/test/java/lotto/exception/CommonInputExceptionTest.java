package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CommonInputExceptionTest {

    @Test
    void 입력이_아무것도_없을_때() {
        assertThatThrownBy(() -> CommonInputException.checkEmptyInput("", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_앞뒤로_공백이_있을_때() {
        assertThatThrownBy(() -> CommonInputException.checkHasBlankInInput(" 12000", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CommonInputException.checkHasBlankInInput("12000 ", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CommonInputException.checkHasBlankInInput(" 10000 ", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CommonInputException.checkHasBlankInInput(" 1,2,3,4,5,6 ", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CommonInputException.checkHasBlankInInput(" 10 ", "입력을"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
