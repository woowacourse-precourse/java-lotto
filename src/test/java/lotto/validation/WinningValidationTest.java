package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private WinningValidation validation;
    private String input;

    @BeforeEach
    void beforeEach() {
        validation = new WinningValidation();
        input = "";
    }

    @DisplayName("로또 당첨 번호와 보너스 번호를 아무것도 입력하지 않은 경우")
    @Test
    void isBlankWinningTest() {
        // given
        input = "  ";

        // when, then
        assertThatThrownBy(() -> validation.isBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 입력이 숫자와 쉼표가 아닌 경우")
    @Test
    void isNumberAndCommaTest() {
        // given
        input = "1,2,3,4,5,육";

        // when, then
        assertThatThrownBy(() -> validation.isNumberAndComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호와 보너스 번호가 1부터 45 사이의 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,56,7", "0", "46"})
    void isCorrectRangeTest(String input) {
        // when, then
        assertThatThrownBy(() -> validation.isCorrectRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 개수(6개)를 잘못 입력한 경우")
    @Test
    void isCorrectWinningSizeTest() {
        // given
        input = "1,2,3,4,5,6,7";

        // when, then
        assertThatThrownBy(() -> validation.isCorrectWinningSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 입력값에 중복이 있는 경우")
    @Test
    void isDuplicateTest() {
        // given
        input = "1,2,3,4,5,2";

        // when, then
        assertThatThrownBy(() -> validation.isDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아닌 경우")
    @Test
    void isNumberTest() {
        // given
        input = "십";

        // when, then
        assertThatThrownBy(() -> validation.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호 개수(1개)를 잘못 입력한 경우")
    @Test
    void isCorrectBonusSizeTest() {
        // given
        input = "9, 33";

        // when, then
        assertThatThrownBy(() -> validation.isCorrectBonusSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호에 포함된 숫자를 입력한 경우")
    @Test
    void isContainWinningTest() {
        // given
        input = "6";
        List<Integer> winnings = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThatThrownBy(() -> validation.isContainWinning(input, winnings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}