package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PlayerTest {

    @DisplayName("올바르지 않은 금액 입력 - 문자 포함")
    @Test
    void test1() {
        String input = "l35000";
        Throwable t = catchThrowable(() -> inputCostForLotto(input));

        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_INPUT_ERROR_MESSAGE);
    }

    @DisplayName("올바르지 않은 금액 입력 - 1000으로 안나눠짐")
    @Test
    void test2() {
        String input = "3500";
        Throwable t = catchThrowable(() -> inputCostForLotto(input));

        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_COST_ERROR_MESSAGE);
    }

    @DisplayName("올바른 금액 입력")
    @Test
    void test3() {
        String input = "35000";
        int result = inputCostForLotto(input);
        assertThat(result).isEqualTo(35);
    }

    private int inputCostForLotto(String input) {

        Validator.validateForIllegalInput(input);

        int cost = Integer.parseInt(input);
        Validator.validateForDividedBy1000(cost);

        return cost / 1000;
    }
}
