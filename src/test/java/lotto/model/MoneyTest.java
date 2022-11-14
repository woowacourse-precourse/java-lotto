package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("돈이 생성된다.")
    @Test
    void createMoney() {
        assertThat(new Money(1_000)).isEqualTo(new Money(1_000));
    }

    @DisplayName("1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void validateMoneyUnit() {
        assertThatThrownBy(() -> new Money(1_500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따라 로또의 개수를 반환한다.")
    @Test
    void countLotto() {
        assertThat(new Money(2_000).countLotto()).isEqualTo(2);
    }
}
