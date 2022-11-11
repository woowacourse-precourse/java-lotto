package lotto;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import java.util.ArrayList;

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

        final String containSpace = "23 ";
        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotNumber(containSpace))
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

    @Test
    @DisplayName("숫자열이 1~45 사이가 아닌지 확인")
    void 구매자_입력시_1_45사이_아니면_예외_테스트(){
        final String numberFortyFive = "46";

        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotNumberRange(numberFortyFive))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        final String numberZero = "0";

        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotNumberRange(numberZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구매자가 입력한 ','가 5개가 아니라면 예외 발생 확인")
    void 구매자_입력이_컨마5개_아니면_예외_테스트(){
        final String sixComma = "1,2,3,4,5,6,";

        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotFiveComma(sixComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        final String zeroComma = "1234";

        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotFiveComma(zeroComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("나눈 숫자열이 6개가 아니면 예외 처리 확인")
    void 구매자_입력시_문자열의_숫자열을_나누기(){
        final String numbers = "11,2,33,44,55,12,23";

        List<Integer> splitList;
        assertThatThrownBy(() -> CheckInputException.checkBuyerInputIsNotSixNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}