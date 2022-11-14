package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.constants.ErrorCode;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void getValue_5000_5000() {
        Money money = new Money(12345);
        assertThat(money.getValue()).isEqualTo(12345);
    }

    @Test
    public void validateMoney_MINUS_500_NOT_NEGETIVE_NUMBER() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(-500);
        });
        assertEquals(ErrorCode.NOT_NEGATIVE_NUMBER.getErrorMessage(), exception.getMessage());
    }
}