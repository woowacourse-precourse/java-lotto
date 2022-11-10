package lotto;

import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @DisplayName("구입 금액은 입력이 1,000원 단위인 경우에만 생성이 가능하다.")
    @Nested
    class CreateMoney {
        @CsvSource({"1,true", "1000,false", "2000,false", "3003,true"})
        @ParameterizedTest(name = "amount : {0}, isNull : {1}")
        void createMoneyByAmountIsNull(int amount, boolean expected) {
            Money money = null;

            try {
                money = new Money(amount);
            } catch (IllegalArgumentException ignored) {
            }

            Assertions.assertThat(Objects.isNull(money)).isEqualTo(expected);
        }
    }
}
