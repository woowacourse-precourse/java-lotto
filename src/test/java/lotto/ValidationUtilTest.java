package lotto;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.ValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidationUtilTest {

    @Test
    @DisplayName("입력 값 공백 여부 검증")

    void isEmpty() {
        String input1 = "";
        String input2 = " ";

        assertThat(ValidationUtil.validateEmpty(input1)).isTrue();
        assertThat(ValidationUtil.validateEmpty(input2)).isFalse();
    }

    @Test
    @DisplayName("입력 문자열의 정수 여부 검증")

    void isDigit() {
        String input1 = "123";
        String input2 = "abc";

        assertThat(ValidationUtil.validateIsDigit(input1)).isTrue();
        assertThat(ValidationUtil.validateIsDigit(input2)).isFalse();
    }

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
    @DisplayName("당첨 번호 입력 시 적절하지 않은 콤마(,) 사용 검증")
    void invalidComma() {
        String input1 = ",1,2,3,4,5,6";
        String input2 = "1,2,3,4,5,6,";
        String input3 = "1,,2,3,4,5,6";

        assertThat(ValidationUtil.invalidComma(input1));
        assertThat(ValidationUtil.invalidComma(input2));
        assertThat(ValidationUtil.invalidComma(input3));
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