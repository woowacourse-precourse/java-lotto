package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @DisplayName("Money 클래스의 생성자가 LottoRule 의 PURCHASE_UNIT 으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByFailDividePurchaseAmountTest() {
        assertThatThrownBy(() -> new Money(2_500))
                .isInstanceOf(IllegalArgumentException.class);
    }

}