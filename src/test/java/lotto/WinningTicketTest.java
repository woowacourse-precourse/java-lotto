package lotto;

import lotto.Model.WinningTicket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningTicketTest {

    @Test
    void 보너스번호_정상입력() {
        WinningTicket ticket = new WinningTicket("1,2,3,4,5,6");
        ticket.saveBonus("7");
        assertThat(ticket.getBonusNum()).isEqualTo(7);
    }

    @Test
    void 보너스번호_중복입력_예외처리() {
        WinningTicket ticket = new WinningTicket("1,2,3,4,5,6");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ticket.saveBonus("3");
        });
    }
}
