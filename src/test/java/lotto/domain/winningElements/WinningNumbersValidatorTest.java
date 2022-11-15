package lotto.domain.winningElements;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class WinningNumbersValidatorTest {
    @EmptySource
    @ParameterizedTest
    void 당첨_번호가_입력되지_않았을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateEmptyWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호가 입력되지 않았습니다.");
    }

    @ValueSource(strings = {"123456", "1", "89", "1234564"})
    @ParameterizedTest
    void 당첨_번호에_콤마가_존재하지_않을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateContainsComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 형식에 맞지 않습니다. (입력된 값에 콤마(,)가 존재하지 않습니다.)");
    }

    @ValueSource(strings = {"12,,456", "13,14,15,,16,45", "8,,,,9,12", "12,,,3,,,,,,45,,4"})
    @ParameterizedTest
    void 당첨_번호에_콤마가_연속으로_입력되었을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateConsecutiveCommas(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 형식에 맞지 않습니다. (콤마(,)가 연속으로 입력되었습니다.)");
    }

    @ValueSource(strings = {"a,12,2,4,5,6", "13,14,15,16,45,z", ",3,13,5,9,12,1,", ",12,3,45,1,4,7", "1,4,5,15,36,42,", "!,1,2,3,4,5", "1,2,3,4,5,^"})
    @ParameterizedTest
    void 당첨_번호의_첫_번째_또는_마지막_값이_숫자가_아닐_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateFirstAndLastAreNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 형식에 맞지 않습니다. (첫 번째 또는 마지막 값이 숫자가 아닙니다.)");
    }

    @ValueSource(strings = {"a,12,2,4,5,6", "13,14,15,16,45,z", "13,5,c,9,12,1", "12,3,가,1,4,7", "1,4,5,15,36,$$", "33,1,@#%A,3,4,5", "1,2,3,4,5,^"})
    @ParameterizedTest
    void 당첨_번호의_콤마를_제외한_값_중에_숫자가_아닌_문자가_있을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateAllCharactersAreDigitExceptComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 형식에 맞지 않습니다. (콤마(,)를 제외한 값 중에 숫자가 아닌 문자가 있습니다.)");
    }

    @ValueSource(strings = {"12,2,4,5,6", "13,14,15,16,45,1,2,3", "1", "12,3", "1,4,5,15", "33,1,23,12,3,4,5,6", "1,2,3"})
    @ParameterizedTest
    void 당첨_번호의_개수가_6개가_아닐_경우_예외처리한다(String input) {
        List<Integer> numbers =
                Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        assertThatThrownBy(() -> WinningNumbersValidator.validateSixElements(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 당첨 번호의 개수가 6개로 이루어져 있지 않습니다.");
    }

    @ValueSource(strings = {"12,2,4,5,6,46", "0,16,45,1,2,3", "-1,-2,-3,1,2,4", "12,3,99,10,56,32", "1,4,5,15,0,3", "33,-99,23,12,3,1"})
    @ParameterizedTest
    void 당첨_번호의_범위에_속하지_않는_수가_존재할_경우_예외처리한다(String input) {
        List<Integer> numbers =
                Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        assertThatThrownBy(() -> WinningNumbersValidator.validateLottoNumberRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 범위인 1 ~ 45에 속하지 않는 수가 입력되었습니다.");
    }

    @ValueSource(strings = {"12,2,4,5,6,6", "1,16,45,1,2,3", "2,2,2,2,2,2", "12,11,10,9,9,9", "4,5,6,1,1,7", "33,33,4,5,8,1"})
    @ParameterizedTest
    void 당첨_번호_중에_중복된_수가_있을_경우_예외처리한다(String input) {
        List<Integer> numbers =
                Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        assertThatThrownBy(() -> WinningNumbersValidator.validateDuplicateNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 당첨 번호에 중복된 수가 있습니다.");
    }
}