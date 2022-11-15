package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("1,000원 단위가 아닌 금액을 입력 받으면 에외가 발생한다.")
    @Test
    void createMoneyNotDivided1000() {
        assertThatThrownBy(() -> new Money(9999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}