package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"8000", " 8 0 0 0", "80 0 0", "00800 0"})
    void 올바른_로또_금액_입력(String input) {
        Purchase ticketNumber = new Purchase(input);
        assertEquals(8, ticketNumber.getTicketNumber());
    }

    @ParameterizedTest
    @DisplayName("1,000원으로 나누어 떨어지지 않는 숫자, 1,000원보다 작은 숫자, 문자는 예외 처리한다.")
    @ValueSource(strings = {"8300", "900", "aaa"})
    void 예외_테스트(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Purchase(input);
        });
    }
}