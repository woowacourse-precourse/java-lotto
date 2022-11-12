package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"lotto", "로또", "", "!", "124fnj", " "})
    void validatePurchaseAmount_메서드는_올바르지_않은_문자열을_입력하면_IllegalArgumentException을_던진다(String amount) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "-1", "1001", "6666"})
    void validatePurchaseAmount_메서드는_허용되지_않은_숫자형식의_문자열을_입력하면_IllegalArgumentException을_던진다(String amount) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "100000", "47000"})
    void validatePurchaseAmount_메서드는_허용된_숫자형식의_문자열을_입력하면_예외가_발생하지_않는다(String amount) {
        InputValidator.validatePurchaseAmount(amount);
    }

    @ParameterizedTest
    @MethodSource("InvalidLottoNumbers")
    void validateLottoNumber_메서드는_올바른_당첨번호와_보너스번호_형식의_문자열을_입력하지_않으면_IllegalArgumentException을_던진다(
            String winningNumbers,
            String bonusNumber) {
        assertThatThrownBy(() -> InputValidator.validateLottoNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static List<Arguments> InvalidLottoNumbers() {
        return Arrays.asList(
                Arguments.of("1,2,3,4,5", "6"),
                Arguments.of("1,2,3,4,5,7", "f"),
                Arguments.of("1,2,3,4,53,4", "6"),
                Arguments.of("1d,2,3,4,5,6", "7"),
                Arguments.of("1,2,3,4,5,6", ""),
                Arguments.of("", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("validLottoNumbers")
    void validateLottoNumber_메서드는_올바른_당첨번호와_보너스_번호를_입력하면_LottoDto를_반환한다(
            String winningNumbers,
            String bonusNumber) {
        LottoDto lottoDto = InputValidator.validateLottoNumber(winningNumbers, bonusNumber);

        assertThat(lottoDto.getWinningNumbers().size()).isEqualTo(6);
        assertThat(lottoDto.getBonusNumber()).isEqualTo(Integer.valueOf(bonusNumber));
    }

    static List<Arguments> validLottoNumbers() {
        return Arrays.asList(
                Arguments.of("1,2,3,4,5,6", "7"),
                Arguments.of("5,12,22,25,35,42", "8"),
                Arguments.of("11,12,13,14,15,16", "17"),
                Arguments.of("1,23,34,42,17,44", "45")
        );
    }

}
