package lotto.domain;

import lotto.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketTest {
    @DisplayName("입력 형식이 숫자가 아닌 경우 예외처리한다.")
    @Test
    void createTicketByNoNumberFormat() {
        assertThatThrownBy(() -> new Ticket("10sdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 티켓 가격으로 나누어 떨어지지 않는 경우 예외처리한다.")
    @Test
    void createTicketByNoMultipleOfThousand() {
        int amount = 10 * LottoConstants.TICKET_PRICE.getValue() + 1;
        if (LottoConstants.TICKET_PRICE.getValue() != 1) {
            assertThatThrownBy(() -> new Ticket(String.valueOf(amount)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
