package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.statistics.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @DisplayName("금액을 로또로 변경시 검증하는 테스트.")
    @Test
    void MoneyTOLottoCntTest() {
        Money money = Money.from(10000);
        assertThat(money.getLottoCnt()).isEqualTo(10);
    }

    @DisplayName("금액이 1000원으로 나눠떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1100, 7777, 9999})
    void createMoneyByDecimals(int input) {
        assertThatThrownBy(() -> Money.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야만 합니다.");
    }
}
