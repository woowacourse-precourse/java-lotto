package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {
    @DisplayName("로또 구매 금액 입력 검증 - 정상 금액 입력")
    @Test
    void enterNormalAmount() {
        String inputAmount = "10000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);

        assertThat(purchaseAmount.getAmount()).isEqualTo(10000);
    }

    @DisplayName("로또 구매 금액 입력 검증 - 문자 입력 시 예외 발생")
    @Test
    void enterString() {
        String inputAmount = "abcde";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액 입력 검증 - 숫자와 문자를 함께 입력할 시 예외 발생")
    @Test
    void enterNumberWithString() {
        String inputAmount = "123abc";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액 입력 검증 - 띄어쓰기만 입력할 시 예외 발생")
    @Test
    void enterSpace() {
        String inputAmount = "   ";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액 입력 검증 - 아무 값도 입력하지 않을 시 예외 발생")
    @Test
    void enterNothing() {
        String inputAmount = "";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구매 금액 입력 검증 - 0을 입력할 시 예외 발생")
    @Test
    void enterZero() {
        String inputAmount = "0";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO.getMessage());
    }

    @DisplayName("로또 구매 금액 입력 검증 - 1000으로 나누어떨어지지 않는 값 입력 시 예외 발생")
    @Test
    void enterNotDividedByThousand() {
        String inputAmount = "12345";

        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(inputAmount))
                .hasMessage(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.getMessage());
    }
}
