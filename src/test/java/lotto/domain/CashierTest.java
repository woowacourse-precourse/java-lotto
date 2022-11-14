package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashierTest {

    private Cashier cashier;

    @BeforeEach
    void setUp() {
        cashier = new Cashier();
    }

    @Test
    void 음수_금액_입력() {
        assertThatThrownBy(() -> cashier.sellLotto(-1234)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_입력이_로또_가격으로_나누어_떨어지지않음() {
        assertThatThrownBy(() -> cashier.sellLotto(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_입력_0원() {
        int lottoAmount = cashier.sellLotto(0);
        assertThat(lottoAmount).isEqualTo(0);
    }

}