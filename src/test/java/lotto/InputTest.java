package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ui.Input;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void validateNumber_메서드_사용시_숫자_입력이_아닐_경우_예외_발생() {
        String inputWithAlphabet = "abc";
        String inputWithKorean = "한글";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateNumber(inputWithAlphabet))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateNumber(inputWithKorean))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateLottoNumber_메서드_사용시_숫자_입력이_아닐_경우_예외_발생() {
        String inputWithAlphabet = "abc";
        String inputWithKorean = "한글";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateLottoNumber(inputWithAlphabet))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateLottoNumber(inputWithKorean))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateLottoNumber_메서드_사용시_1_부터_45_범위의_숫자가_아닐_경우_예외_발생() {
        String inputWithAlphabet = "0";
        String inputWithKorean = "46";

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateLottoNumber(inputWithAlphabet))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateLottoNumber(inputWithKorean))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validatePrice_메서드_사용시_1000으로_나누어_떨어지지_않을_경우_예외_발생() {
        int price = 11500;

        assertThatThrownBy(() -> Input.validatePrice(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateSplitByCommaInputSize_메서드_사용시_6개의_입력으로_나누어지지_않을_경우_예외_발생() {
        String inputWithFourCommas = "1,2,3,4,5";
        String inputWithSixCommas = "1,2,3,4,5,6,7";
        String[] inputWithFourCommasSplitByComma = inputWithFourCommas.split(",");
        String[] inputWithSixCommasSplitByComma = inputWithSixCommas.split(",");

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateSplitByCommaInputSize(inputWithFourCommasSplitByComma))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateSplitByCommaInputSize(inputWithSixCommasSplitByComma))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateNonDuplicatedLottoNumbers_메서드_사용시_Set의_사이즈가_6이_아닐_경우_예외_발생() {
        Set<Integer> setWithFiveNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> setWithSevenNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7));

        assertAll(
                () -> assertThatThrownBy(() -> Input.validateNonDuplicatedLottoNumbers(setWithFiveNumbers))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Input.validateNonDuplicatedLottoNumbers(setWithSevenNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
