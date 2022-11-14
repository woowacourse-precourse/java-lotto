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
    void inputTextIncludedComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("800,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.NOT_DIGIT_TEXT.getMessage())
        );
    }

    @DisplayName("금액의 길이가 10만(100000)의 길이 6을 넘는다면 예외 발생.")
    @Test
    void inputByOverSevenLength() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage())
        );
    }

    @DisplayName("구매 금액이 10만원을 넘는다면 예외 발생.")
    @Test
    void inputAmountPaidByOverOneMillionWon() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("100001"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage())
        );
    }

    @DisplayName("구매 금액이 1000원 이하라면 예외 발생.")
    @Test
    void inputZeroAmountPaid() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage())
        );
    }

    @DisplayName("구매 금액이 1000원으로 나눠지지 않는다면 예외 발생.")
    @Test
    void inputIndivisibleAmountPaid() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("5500"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.NOT_DIVISION.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Buying buying = new Buying();
    }

}
