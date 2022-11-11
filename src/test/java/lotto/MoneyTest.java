package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.Money;
import lotto.utils.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @DisplayName("정확한 구매금액을 입력한 경우 정상적으로 값이 들어간다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 50000, 90000})
    void getMoney(int input) {
        Money money = new Money(input);
        assertThat(money.getMoney())
                .isEqualTo(input);
    }

    @DisplayName("구매 금액이 1000원보다 작은 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {850, 999, 764, 1})
    void getMoneyByLowerThan1000(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOWER_THAN_LOTTO_PRICE.getMessage());
    }

    @DisplayName("구매 금액이 1000원으로 나누어 떨어지지 않는 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2202, 9999})
    void getMoneyByDivideInto1000(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_DIVISION_INTO_LOTTO_PRICE.getMessage());

    }

}
