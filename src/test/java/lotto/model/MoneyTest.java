package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.constants.ErrorCode;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void validNumber_exception_message_test() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money("string");
        });
        assertEquals(ErrorCode.NOT_NUMBER.getErrorMessage(), exception.getMessage());
    }

    @Test
    public void validBill_exception_message_test() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money("21002");
        });
        assertEquals(ErrorCode.NOT_BILL.getErrorMessage(), exception.getMessage());
    }
}