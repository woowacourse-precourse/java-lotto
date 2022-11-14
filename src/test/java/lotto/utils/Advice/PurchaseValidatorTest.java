package lotto.utils.Advice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseValidatorTest {
    @DisplayName("구매수량 입력시 숫자 이외 다른 것을 입력하면 예외가 발생한다.")
    @Test
    void purchaseLottoQtyCheckInput() {
        String input = "1,000";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseValidator.checkConsistNumber(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자 이외의 값을 입력하셨습니다. | 입력 : 1,000");
    }

    @DisplayName("구매수량 입력시 숫자 이외 다른 것을 입력하면 예외가 발생한다.(공백)")
    @Test
    void purchaseLottoQtyCheckInputSpace() {
        String input = "1000  ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseValidator.checkConsistNumber(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자 이외의 값을 입력하셨습니다. | 입력 : 1000  ");
    }

    @DisplayName("구매수량 입력 시 1000원 단위로 입력하지 않을 시 예외가 발생한다.")
    @Test
    void purchaseLottoQtyCheckReminder() {
        String input = "150300";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseValidator.checkReminder(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1000원 단위로 구매하실 수 있습니다. | 입력 : 150300");
    }
}