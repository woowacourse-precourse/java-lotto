package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManagerTest {
    @DisplayName("로또 수량 확인")
    @Test
    void getAmountFromPrice() {
        Manager manager = new Manager();
        int result = manager.getAmount(20000);
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("잘못된 금액일경우 예외발생")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {15500, 900, 0})
    void getAmountFromPriceButException(int won) {
        Manager manager = new Manager();
        assertThatThrownBy(() -> manager.getAmount(won)).isInstanceOf(IllegalArgumentException.class);
    }
}
