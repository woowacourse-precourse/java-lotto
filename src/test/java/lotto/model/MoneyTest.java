package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.constants.ErrorCode;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void getMonee_5000_5000() {
        Money money = new Money(5000);
        assertThat(money.getMoney()).isEqualTo(5000);
    }

    @Test
    public void NotBill_21002_exception_message_test() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(21002);
        });
        assertEquals(ErrorCode.NOT_BILL.getErrorMessage(), exception.getMessage());
    }

    @Test
    public void NotBill_500_NOTBILL() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(500);
        });
        assertEquals(ErrorCode.NOT_BILL.getErrorMessage(), exception.getMessage());
    }
}