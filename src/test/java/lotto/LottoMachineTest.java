package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("로또 구입금액이 1000원 미만일 경우 예외가 발생한다.")
    @Test
    void createLessThanMinMoney() {
        assertThatThrownBy(() -> lottoMachine.inputMoney(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createWrongMoneyUnit() {
        assertThatThrownBy(() -> lottoMachine.inputMoney(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}