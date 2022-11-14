package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    @Test
    void 올바른_로또_금액_입력() {
        Purchase ticketNumber = new Purchase("8000");
        assertEquals(8, ticketNumber.getTicketNumber());
    }

    @Test
    @DisplayName("1,000원으로 나누어 떨어지지 않는 숫자를 입력하는 경우 예외 처리한다.")
    void 천원으로_나누어_떨어지지_않는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Purchase("8_300");
        });
    }

    @Test
    @DisplayName("1,000원보다 작은 금액을 입력하는 경우 예외 처리한다.")
    void 최소_금액보다_작은_금액_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Purchase("900");
        });
    }

    @Test
    @DisplayName("입력값이 숫자가 아니면 예외 처리한다.")
    void 숫자가_아닌_입력값() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Purchase("aaa");
        });
    }
}