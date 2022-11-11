package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @DisplayName("금액이 1000원보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100, 999})
    void createMoneyByLessThan1000(int input) {
        assertThatThrownBy(() -> Money.from((input)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액의 최소단위는 1000원입니다.");

    }
    @DisplayName("금액이 1000원으로 나눠떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1100, 7777, 9999})
    void createMoneyByDecimals(int input) {
        assertThatThrownBy(() -> Money.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1000 단위여야 합니다");
    }
}
