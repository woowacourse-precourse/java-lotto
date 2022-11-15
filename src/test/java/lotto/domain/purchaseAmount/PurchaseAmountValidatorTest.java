package lotto.domain.purchaseAmount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {
    @EmptySource
    @ParameterizedTest
    void 구매_금액이_입력되지_않았을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateEmptyPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액이 입력되지 않았습니다.");
    }

    @ValueSource(strings = {"abc", "1a2", "89!@#8", "가나다", "z$3"})
    @ParameterizedTest
    void 숫자가_아니거나_숫자가_아닌_문자가_포함되어_있을_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.");
    }

    @ValueSource(strings = {"1", "222", "999", "-1", "0", "-999"})
    @ParameterizedTest
    void 천_원_미만의_값인_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateLessThanOneThousand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 미만의 값입니다.");
    }

    @ValueSource(strings = {"1001", "2222", "999", "1110", "6060", "999990"})
    @ParameterizedTest
    void 천_원_단위가_아닌_경우_예외처리한다(String input) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateNotDividedByOneThousand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위가 아닙니다.");
    }
}