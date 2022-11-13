package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.utils.ErrorMessages.BONUS_NUMBER_NOT_INTEGER;
import static lotto.utils.ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByNotInteger() {
        assertThatThrownBy(() -> new BonusNumber("I am developing a lot thanks to woowacourse!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_NOT_INTEGER);
    }

    @DisplayName("보너스 번호가 1~45 사이의 값이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "46", "100", "a"})
    void createBonusNumberByOutOfRange(String number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("입력받은 보너스 번호를 정수형으로 변환한다.")
    @ParameterizedTest
    @CsvSource({"1,1", "45,45", "12,12"})
    void getBonusNumber(String number, int expected) {
        BonusNumber bonusNumber = new BonusNumber(number);
        assertThat(bonusNumber.getNumber()).isEqualTo(expected);
    }
}
