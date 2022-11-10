package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    Money money;

    @Test
    void 금액이_1000원_단위가_아닐_경우() {
        Assertions.assertThatThrownBy(() -> {
            money = new Money("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위의 금액을 입력해야 합니다.");
    }

}