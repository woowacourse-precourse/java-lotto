package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class lottoTicketTest {
    @DisplayName("Throw Exception when there is change after buy Lottery.")
    @Test
    void changesLeftAfterBuyLottery() {
        assertThatThrownBy(() -> LottoTicket.countPaidLotteryTickets(3050)).isInstanceOf(IllegalArgumentException.class);
    }

}
