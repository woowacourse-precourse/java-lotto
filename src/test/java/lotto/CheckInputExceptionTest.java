package lotto;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CheckInputExceptionTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    @DisplayName("사용자의 입력이 음수이면 예외처리 되는지 확인")
    void 구매자_음수_입력시_예외_테스트(){

        final String number = "-123";
        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsMinus(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("사용자의 입력이 숫자열이 아니면 예외 처리 되는지 확인")
    void 구매자_문자열_입력시_예외_테스트(){

        final String string = "123a";
        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotNumber(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지않는지 확인")
    void 구매자_입력시_1000으로_나누어_떨어지는지_예외_테스트(){

        final String numberic = "4321";
        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotDivided(numberic))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}