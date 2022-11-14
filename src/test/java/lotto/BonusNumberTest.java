package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.utils.ErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BonusNumberTest {
    private WinningLotto winningLotto;

    @BeforeAll
    void setUp() {
        winningLotto = new WinningLotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByNotInteger() {
        assertThatThrownBy(() -> new BonusNumber("Thanks you, woowacourse!", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_NOT_INTEGER);
    }

    @DisplayName("보너스 번호가 1~45 사이의 값이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "46", "100"})
    void createBonusNumberByOutOfRange(String number) {
        assertThatThrownBy(() -> new BonusNumber(number, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void createBonusNumberByDuplicatedWinningNumbers(String number) {
        assertThatThrownBy(() -> new BonusNumber(number, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATED);
    }

    @DisplayName("입력받은 보너스 번호를 정수형으로 변환한다.")
    @ParameterizedTest
    @CsvSource({"10,10", "45,45", "12,12"})
    void getBonusNumber(String number, int expected) {
        BonusNumber bonusNumber = new BonusNumber(number, winningLotto);
        assertThat(bonusNumber.getNumber()).isEqualTo(expected);
    }
}
