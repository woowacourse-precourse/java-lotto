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
        String number = "-123";

        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsMinus(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}