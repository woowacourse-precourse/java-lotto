package lotto.domain.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {


    @Test
    public void amountOfMoneyExceptionTest() throws Exception {
        assertThatThrownBy(() -> Money.from(1500)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void moneyDoesNotExceptionTest() throws Exception {
        assertDoesNotThrow(() -> Money.from(1000));
    }
}
