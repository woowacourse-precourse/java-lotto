package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.lottoTicket;

class lottoTicketTest {
    @DisplayName("Throw Exception when there is change after buy Lottery.")
    @Test
    void changesLeftAfterBuyLottery() {
        assertThatThrownBy(() -> lottoTicket.countPaidLotteryTickets(3050)).isInstanceOf(IllegalArgumentException.class);
    }
}
