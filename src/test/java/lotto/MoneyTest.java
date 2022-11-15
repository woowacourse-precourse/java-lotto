package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("수익률은 총 수익에 로또 구입 금액을 나눈 후 100을 곱해준 값이며, 소수점 둘째자리에서 소수점해서 나타낸다.")
    @Test
    void yieldTwoPointRound() {
        Yield yield1 = new Yield(Money.createPurchaseMoney("5000"), new Money(50000));
        Yield yield2 = new Yield(Money.createPurchaseMoney("5000"), new Money(5000));
        Yield yield3 = new Yield(Money.createPurchaseMoney("5000"), new Money(0));
        Yield yield4 = new Yield(Money.createPurchaseMoney("5000"), new Money(625));

        Assertions.assertThat(yield1.toString()).isEqualTo("1000.0%");
        Assertions.assertThat(yield2.toString()).isEqualTo("100.0%");
        Assertions.assertThat(yield3.toString()).isEqualTo("0.0%");
        Assertions.assertThat(yield4.toString()).isEqualTo("12.5%");
    }
}
