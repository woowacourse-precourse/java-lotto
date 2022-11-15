package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest extends NsTest {
    @DisplayName("입력받은 보너스 번호는 숫자여야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,6:a", "1000:1,2,3,4,5,6:2a"}, delimiter = ':')
    void checkBonusNumberInRange(String firstInput, String secondInput, String thirdInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput, thirdInput);
            assertThat(output()).contains(Validation.LOTTO_INPUT_MUST_NUMBER);
        });
    }

    @DisplayName("입력받은 보너스 번호가 2자리 이상일 때 앞자리는 0이 될 수 없다.")
    @Test
    void checkBounusNumberFirstIsNotZero() {
        String input = "02";

        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validation.FIRST_NUMBER_IS_NOT_ZERO);
    }

    @DisplayName("입력받은 보너스 번호가 1~45 안의 값인지")
    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void checkBounusNumberInRange(String input) {
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validation.LOTTO_NUMBER_IN_RANGE);
    }

    @DisplayName("입력받은 보너스 번호가 당첨번호와 중복이 되선 안된다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,6:1", "1000:1,2,3,4,5,6:6"}, delimiter = ':')
    void checkBonusNumberDistinctWinningNumber(String firstInput, String secondInput, String thirdInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput, thirdInput);
            assertThat(output()).contains(Validation.BONUS_DISTINCT_WINNING_NUMBER);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
