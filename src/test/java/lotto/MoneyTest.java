package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    private static final String EXCEPTION_MESSAGE_OVER_NUMBER_RANGE = "[ERROR] 최소 %d원, 최대%d원 만큼 구매 가능합니다.";
    private static final String NO_DIVIDE_PRICE_EXCEPTION_MESSAGE = "[ERROR] %d원 단위의 금액을 입력 해야합니다.";
    private static final int MAX_PURCHASE = 100000;
    private static final int MIN_PURCHASE = 1000;
    private static final int PRICE = 1000;

    @DisplayName("구매금액이 올바를경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 11000, 100000})
    void createMoney(int input) {
        boolean result = true;
        try {
            new Money(input);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("구매금액이 최소값과 최댓값사이에 없으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, 999, 100001})
    void createMoneyByOverRangeNumber(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining((String.format(EXCEPTION_MESSAGE_OVER_NUMBER_RANGE,
                        MIN_PURCHASE, MAX_PURCHASE)));
    }

    @DisplayName("구매금액이 1000원으로 나눠지지않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2001, 99999})
    void createMoneyNotDividePrice(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(NO_DIVIDE_PRICE_EXCEPTION_MESSAGE, PRICE));
    }
}
