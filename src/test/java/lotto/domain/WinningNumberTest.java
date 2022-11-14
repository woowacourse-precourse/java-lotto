package lotto.domain;

import static lotto.io.Message.INPUT_6_NUMBERS_WITH_COMMA;
import static lotto.io.Message.INPUT_FROM_1_TO_45;
import static lotto.io.Message.WITHOUT_OVERLAP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨 번호 입력")
    @Test
    void testInputWinningNumbers() {
        String input = "1,2,3,4,5,6";

        assertThat(WinningNumber.saveWinningNumbers(input)).isNotNull();
    }

    @DisplayName("당첨번호 중복 값 입력으로 실패")
    @Test
    void testOverlapInput() {
        String input = "1,2,3,4,5,5";

        assertThatThrownBy(() -> WinningNumber.saveWinningNumbers(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(WITHOUT_OVERLAP);
    }

    @DisplayName("당첨번호 6개가 아닌 값 입력")
    @Test
    void testNot6Numbers() {
        String input1 = "1,2,3,4,5";
        String input2 = "1,2,3,4,5,6,7";

        assertAll(
            () -> assertThatThrownBy(() -> WinningNumber.saveWinningNumbers(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_6_NUMBERS_WITH_COMMA),

            () -> assertThatThrownBy(() -> WinningNumber.saveWinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_6_NUMBERS_WITH_COMMA)
        );
    }

    @DisplayName("당첨번호 잘못된 범위의 값 입력")
    @Test
    void testLottoRange() {
        String input1 = "1,2,3,4,5,46";
        String input2 = "0,1,2,3,4,5";

        assertAll(
            () -> assertThatThrownBy(() -> WinningNumber.saveWinningNumbers(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_FROM_1_TO_45),

            () -> assertThatThrownBy(() -> WinningNumber.saveWinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_FROM_1_TO_45)
        );
    }

}