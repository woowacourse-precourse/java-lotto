package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @DisplayName("Throw Exception when there is change after buy Lottery.")
    @Test
    void changesLeftAfterBuyLotteryTest() {
        assertThatThrownBy(() -> LottoTicket.countPaidLotteryTickets(3050)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Check how many tickets were paid")
    @Test
    void countPaidLotteryTicketsTest() {
        int result = LottoTicket.countPaidLotteryTickets(5000);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("Check that numbers are sorted in acending order.")
    @Test
    void lottoNumberOrderTest() {
        List<List<Integer>> numberList = new ArrayList<>();
        numberList = LottoTicket.paidLotteryNumberGenerator(3);
        int ticketNo = 2;
        int result=0;
        for (int index = 0; index < 5; index++) {
            if (numberList.get(ticketNo).get(index) > numberList.get(ticketNo).get(index + 1)) {
                result = 1;
            }
        }
        assertThat(result).isEqualTo(0);
    }




}
