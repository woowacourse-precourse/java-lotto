package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 티켓_금액_오류_확인() {
        User user = new User();
        int ticketMoney = 1500;
        RuntimeException ex = assertThrows(RuntimeException.class, () -> user.buyTicketMoney(ticketMoney));
        assertThat(ex.getMessage()).contains(ERROR_MESSAGE);
    }
@Test
    void 로또_구입_개수_확인() {
        User user = new User();
        user.buyTicket(3);
        assertThat(user.getLottos().size()).isEqualTo(3);
    }
}