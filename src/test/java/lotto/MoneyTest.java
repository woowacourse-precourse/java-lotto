package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    @DisplayName("생성자 생성 성공")
    void testMoney() {
        Money money = new Money(1000);

        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @Test
    @DisplayName("생성자 생성 실패")
    void testMoneyFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(100));
    }

    @Test
    @DisplayName("1000으로 나누기 성공")
    void testCalculateLottoCount() {
        Money money = new Money(10000);
        int calculateLottoCount = money.calculateLottoCount();

        assertThat(calculateLottoCount).isEqualTo(10);
    }
}
