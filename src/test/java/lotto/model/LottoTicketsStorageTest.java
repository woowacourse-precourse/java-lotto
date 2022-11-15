package lotto.model;

import lotto.controller.TicketMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsStorageTest {

    @DisplayName("로또 티켓 발행 저장 여부 확인")
    @Test
    void lottoTicketsStorageTest() {
        LottoStorage lottoTicketsStorage = new LottoStorage();
        lottoTicketsStorage.setLottoTickets(TicketMachine.issueTickets(5));
        assertThat(lottoTicketsStorage.getLottoTickets().size()).isEqualTo(5);
    }
}
