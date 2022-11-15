package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("입력 금액이 범위 밖의 수를 입력 받으면 예외가 발생한다.(1000원 단위의 자연수)")
    @ParameterizedTest
    @CsvSource({"-1000", "1234"})
    void createMoneyByOutArrangeNum(int amount) {
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}