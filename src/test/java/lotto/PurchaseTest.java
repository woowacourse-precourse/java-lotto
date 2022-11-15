package lotto;

import lotto.exception.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @DisplayName("입력 금액이 숫자가 아닐 경우 오류가 발생한다.")
    @Test
    void createPurchaseByNotNumber() {
        assertThatThrownBy(() ->
                PurchaseAmount.exceptionPurchaseAmount("100j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000원보다 적을 때 오류가 발생한다.")
    @Test
    void createPurchaseByLessPrice() {
        assertThatThrownBy(() ->
                PurchaseAmount.exceptionPurchaseAmount("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력금액이 1000원으로 나누어 떨어지지 않을 때 오류가 발생한다.")
    @Test
    void createPurchaseByNotDivide() {
        assertThatThrownBy(() ->
                PurchaseAmount.exceptionPurchaseAmount("1400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}