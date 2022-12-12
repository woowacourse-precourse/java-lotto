package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoQuantityTest {
    @DisplayName("로또 발행 횟수를 계산한다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "8000,8", "151000,151"})
    void createLottoBuyCount(String inputMoney, int expected) {
        Money money = new Money(inputMoney);
        LottoQuantity lottoBuyCount = new LottoQuantity(money);
        assertThat(lottoBuyCount.getCount()).isEqualTo(expected);
    }
}
