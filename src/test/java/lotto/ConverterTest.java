package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class ConverterTest {
    @DisplayName("입력한 당첨번호에 ','와 숫자가 아닌 문자가 존재하면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 3, 2, 4, 5, 7;", "1, 2, 3, 4 + 5 , 6, 7"})
    void inputNumbersByInvalidSeparator(String input) {
        assertThatThrownBy(() -> Converter.convertNumbersInput(input))
                .isInstanceOf(IllegalArgumentException.class);
       }

    @DisplayName("사용자가 올바르지 않은 money를 넣을 시 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"1,000", "1_000", "30,000"})
    void inputMoneyByInvalidForm(String input) {
        assertThatThrownBy(() -> Converter.convertMoneyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 숫자가 아닌 보너스 숫자를 넣을 시 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"일", "삼", "육", "seven"} )
    void inputBonusNumberByInvalidForm(String input) {
        assertThatThrownBy(() -> Converter.convertBonusNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
