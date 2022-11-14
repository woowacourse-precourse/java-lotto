package lotto;

import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {
    final Purchase purchase = new Purchase();

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputAmountWithInvalidUnit() {
        assertThatThrownBy(() -> purchase.checkAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputAmountWithLetter(){
        assertThatThrownBy(() -> purchase.checkAmount("3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
