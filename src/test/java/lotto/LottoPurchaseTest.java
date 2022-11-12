package lotto;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseTest {

    @Test
    void 구입금액에따른로또개수테스트(){
        PurchaseMachine purchase = new PurchaseMachine();
        purchase.countTicket(8000);
        assertThat(purchase.numberOfTickets).isEqualTo(8);
    }
}