package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @DisplayName("투입금액이 로또한개구입 비용으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoMachineIndivisibleMoney() {
        int money = 1234;
        assertThatThrownBy(() -> new LottoMachine(money));
    }

    @DisplayName("투입금액이 유효하지 않으면(음수) 예외가 발생한다.")
    @Test
    void createLottoMachineInvalidMoney() {
        int money = -1;
        assertThatThrownBy(() -> new LottoMachine(money));
    }
}
