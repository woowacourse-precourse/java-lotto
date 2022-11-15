package lotto.domain.winningElements;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BonusNumberValidatorTest {
    @EmptySource
    @ParameterizedTest
    void 보너스_번호가_입력되지_않았을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateEmptyBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호가 입력되지 않았습니다.");
    }

    @ValueSource(strings = {"abc", "1a2", "89!@#8", "가나다", "z$3"})
    @ParameterizedTest
    void 보너스_번호가_숫자가_아니거나_숫자가_아닌_문자가_포함되어_있을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 보너스 번호가 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.");
    }

    @ValueSource(strings = {"0", "46", "999", "-1", "90", "-999"})
    @ParameterizedTest
    void 보너스_번호가_로또_번호_범위에_속하지_않을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 보너스 번호는 로또 번호 범위인 1 ~ 45에 속하지 않습니다.");
    }

    @CsvSource(value = {
            "3 : 1 : 2 : 3 : 4 : 5 : 6",
            "17 : 11 : 13 : 15 : 17 : 25 : 37",
            "9 : 34 : 42 : 45 : 7 : 9 : 18",
            "41 : 3 : 29 : 32 : 17 : 5 : 41",
            "30 : 13 : 42 : 40 : 30 : 25 : 8",
            "8 : 1 : 8 : 24 : 37 : 35 : 5"
    }, delimiter = ':')
    @ParameterizedTest
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외처리한다(String bonusNumber, int one, int two, int three, int four, int five, int six) {
        List<Integer> winningNumbers = new ArrayList<>(
                Arrays.asList(one, two, three, four, five, six));

        assertThatThrownBy(() -> BonusNumberValidator.validateDuplicationOfBonusNumberWithWinningNumbers(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 보너스 번호는 앞서 입력한 당첨 번호와 중복되는 값 입니다.");
    }
}