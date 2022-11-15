package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("Money 생성자 예외(1,000원 이하 금액, 1,000원 단위 아닌 금액) 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 1100})
    void moneyConstructorTest(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 개수 세기 테스트")
    @ParameterizedTest
    @ValueSource(ints = {55000})
    void lottoCountByMoneyTest(int input) {
        Money money = new Money(input);
        int expected = 55;
        assertThat(money.countLotto()).isEqualTo(expected);
    }
}
