package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
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
}
