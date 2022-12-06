package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    @DisplayName("입력한 money를 amount로 변환")
    void moneyToAmount() {
        Money money = new Money("5000");
        Assertions.assertThat(money.moneyToAmount()).isEqualTo(5);
    }
}