package lotto.view;

import static java.lang.Integer.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
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
        assertThatThrownBy(() -> InputValidator.validateBuyAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "-1", "1001", "6666"})
    void validatePurchaseAmount_메서드는_허용되지_않은_숫자형식의_문자열을_입력하면_IllegalArgumentException을_던진다(String amount) {
        assertThatThrownBy(() -> InputValidator.validateBuyAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "100000", "47000"})
    void validatePurchaseAmount_메서드는_허용된_숫자형식의_문자열을_입력하면_Integer_형식의_구매금액을_반환한다(String amount) {
        Integer purchaseAmount = InputValidator.validateBuyAmount(amount);
        assertThat(purchaseAmount).isEqualTo(valueOf(amount));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4",
            "1,2,3,4,5,5",
            "1,2,3,4,53,5",
            "1d,2,3,4,5,6",
            "1,2,3,4,5,6,8",
            "",
            "1, 2, 3, 4, 5, 6",
            "1, 2,3,4,5,6",
            " 1,2,3,4,5,6",
            "1,2,3,4,5,6 ",
            "123456"
    })
    void validateWinningNumbers_메서드는_올바른_당첨번호_형식의_문자열을_입력하지_않으면_IllegalArgumentException을_던진다(
            String winningNumbers
    ) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidBonusNumbers")
    void validateLottoNumber_메서드는_올바른_당첨번호와_보너스번호_형식의_문자열을_입력하지_않으면_IllegalArgumentException을_던진다(
            List<Integer> winningNumbers,
            String bonusNumber
    ) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static List<Arguments> invalidBonusNumbers() {
        return Arrays.asList(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "1"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "6"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "f"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "7hello"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), ""),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "46"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "0")
        );
    }

    @Test
    void validateWinningNumbers_메서드는_올바른_당첨번호_형식의_문자열을_입력하면_숫자_리스트를_반환한다() {
        String inputWinningNumbers = "1,2,3,4,5,6";
        List<Integer> winningNumbers = InputValidator.validateWinningNumbers(inputWinningNumbers);
        assertThat(winningNumbers).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void validateBonusNumber_메서드는_올바른_보너스번호_형식의_문자열을_입력하면_보너스번호를_반환한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String inputBonusNumber = "45";
        Integer bonusNumber = InputValidator.validateBonusNumber(winningNumbers, inputBonusNumber);
        assertThat(bonusNumber).isEqualTo(45);
    }
}
