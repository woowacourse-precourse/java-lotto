package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashierTest {

    private Cashier cashier;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        cashier = new Cashier();
    }

    @Test
    void 음수_금액_입력() {
        assertThatThrownBy(() -> cashier.sellLotto(-1234, lottos)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액_입력이_로또_가격으로_나누어_떨어지지않음() {
        assertThatThrownBy(() -> cashier.sellLotto(1001, lottos)).isInstanceOf(IllegalArgumentException.class);
    }


}