package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyToQuantityChangerTest {

    @DisplayName("숫자를 1000단위로 나누서 수량 계산하기")
    @Test
    void count_quantity() {
        assertThat(MoneyToQuantityChanger.change(10000)).isEqualTo(10);
        assertThat(MoneyToQuantityChanger.change(20000)).isEqualTo(20);
    }
}
