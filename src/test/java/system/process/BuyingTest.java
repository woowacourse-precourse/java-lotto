package system.process;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import system.process.exception.IllegalArgument;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyingTest extends NsTest {

    @DisplayName("금액에 쉼표가 포함되어 있다면 예외 발생.")
    @Test
    void inputTextIncludedComma(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("800,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.NOT_DIGIT_TEXT.getMessage())
        );
    }

    @DisplayName("금액의 길이가 100만(1000000)의 길이 7을 넘는다면 예외 발생.")
    @Test
    void inputByOverSevenLength(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10000000"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage())
        );
    }

    @DisplayName("구매 금액이 100만원을 넘는다면 예외 발생.")
    @Test
    void inputAmountPaidByOverOneMillionWon(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000001"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage())
        );
    }

    @DisplayName("구매 금액이 천원으로 나눠지지 않는다면 예외 발생.")
    @Test
    void inputIndivisibleAmountPaid(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("5500"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.NOT_DIVISION.getMessage())
        );
    }

    @Override
    protected void runMain(){
        Buying buying = new Buying();
    }

}
