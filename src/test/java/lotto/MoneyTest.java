package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    String errorTag = "[ERROR]";
    String erroMsg = "올바르지 못한 돈입니다.";

    @DisplayName("복권 살돈이 정확히 나온다.")
    @Test
    public void test() {
        Money expect = new Money(1000);
        assertThat(expect.getPayLottos()).isEqualTo(1);
    }

    @DisplayName("천원단위가 아닌경우")
    @Test
    public void errorTest() {
        assertThatThrownBy(() -> new Money(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTag)
                .hasMessageContaining(erroMsg);
    }

    @DisplayName("음수인경우")
    @Test
    public void minusMoneyTest() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTag)
                .hasMessageContaining(erroMsg);
    }
}