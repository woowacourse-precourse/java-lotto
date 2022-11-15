package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @DisplayName("생성자 생성 성공")
    @Test
    void testMoney() {
        Money money = new Money(1000);

        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @DisplayName("생성자 생성 실패")
    @Test
    void testMoneyFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(100));
    }

    @DisplayName("1000으로 나누기 성공")
    @Test
    void testCalculateLottoCount() {
        Money money = new Money(10000);
        int calculateLottoCount = money.calculateLottoCount();

        assertThat(calculateLottoCount).isEqualTo(10);
    }
}
