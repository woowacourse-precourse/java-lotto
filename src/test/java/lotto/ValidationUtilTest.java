package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidationUtilTest {

    @Test
    @DisplayName("로또 구입 금액 입력값 정적성 검토")
    void validatePurchaseAmountInput() {
        int purchaseAmount = -1004;

        boolean isPositiveNum = ValidationUtil.validateMinNumber(purchaseAmount);
        boolean isRemainder = ValidationUtil.validateRemainder(purchaseAmount);

        assertThat(isPositiveNum).isFalse();
        assertThat(isRemainder).isFalse();
    }

    @Test
    @DisplayName("당첨 번호 입력값이 숫자 또는 콤마인지 여부 검증")
    void isDigitAndComma() {
        String winningNum1 = "1,2,3,4,5,6";
        String winningNum2 = "a,2,3,4,5,6";
        String winningNum3 = "1, 2, 3, 4, 5, 6";

        assertThat(ValidationUtil.validateIsDigitAndComma(winningNum1)).isTrue();
        assertThat(ValidationUtil.validateIsDigitAndComma(winningNum2)).isFalse();
        assertThat(ValidationUtil.validateIsDigitAndComma(winningNum3)).isFalse();
    }

    @Test
    @DisplayName("입력값의 정수 여부 검토")
    void validateIsDigit() {
        String input = "17";
        String input2 = "a";

        boolean isDigit = ValidationUtil.validateIsDigit(input);
        boolean isDigit2 = ValidationUtil.validateIsDigit(input2);

        assertThat(isDigit).isTrue();
        assertThat(isDigit2).isFalse();
    }

    @Test
    @DisplayName("입력값의 숫자 범위 테스트")
    void validateIsInRange() {
        int input = 17;
        int input2 = 46;

        boolean isInRange = ValidationUtil.validateIsInRange(input);
        boolean isInRange2 = ValidationUtil.validateIsInRange(input2);

        assertThat(isInRange).isTrue();
        assertThat(isInRange2).isFalse();
    }
}