package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMakerTest {
    private LottoMaker lottoMaker;

    @BeforeEach
    void setUp() {
        lottoMaker = new LottoMaker();
    }

    @Test
    @DisplayName("인자로 주어진 ticketCount만큼 로또를 생성한다.")
    void makeLottoTickets() {
        //Given
        int ticketCount = 7;
        //When
        List<Lotto> lottoTickets = lottoMaker.makeLottoTickets(ticketCount);
        //Then
        assertThat(lottoTickets.size()).isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행하는 갯수를 리턴한다. ")
    void calculateTicketCount() {
        //Given
        int money = 14000;
        //When
        int ticketCount = lottoMaker.calculateTicketCount(money);
        //Then
        assertThat(ticketCount).isEqualTo(14);
    }
}