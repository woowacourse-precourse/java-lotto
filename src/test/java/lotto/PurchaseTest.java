package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {


    @DisplayName("결제금액 입력값 유효성 검사 확인")
    @ParameterizedTest
    @CsvSource(value = {"abc", "1001"})
    void validatePurchaseMoneyTest(String purchaseMoney) {
        Assertions.assertThatThrownBy(() -> Purchase.validatePurchaseMoney(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("수익률 계산 확인")
    @ParameterizedTest
    @CsvSource(value = {"8000:5000:62.5f", "9000:5000:55.6f"}, delimiter = ':')
    void calcEarningRateTest(int money, int earn, float rate) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseMoney(money);

        float earningRate = purchase.clacEarningRate(earn);
        Assertions.assertThat(earningRate).isEqualTo(rate);
    }
}