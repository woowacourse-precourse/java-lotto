package lotto.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakerTest {
    private  static LottoMaker lottoMaker;
    @BeforeEach
    void initAll(){
        int lotteryAmount = 6;
        lottoMaker = new LottoMaker(6);
    }

    @DisplayName("하나의 로또지가 제대로 발행되는지 검증")
    @Test
    void publishLotteryTicketsTest(){
        // given
        List<Integer> ticket = lottoMaker.publishLottoTicket();
        boolean result = true;
        // when
        for (Integer lotto:ticket) {
            if(lotto>45||lotto<0){
                result = false;
            }
        }
        // then
        System.out.println(ticket);
        assertThat(result).isTrue();
    }

    @DisplayName("원하는만큼 로또가 발행되는지 검증")
    @Test
    void issueLotteryTicketsTest(){
        // when
        lottoMaker.issueLottoTickets();
        // then
        List<Lotto> tickets = lottoMaker.getLottoTickets();
        assertThat(tickets.size()).isEqualTo(6);
    }

    @DisplayName("로또지 출력 검증")
    @Test
    void printLottoTicketsTest(){
        // when
        lottoMaker.issueLottoTickets();
        lottoMaker.printLottoTickets();
    }

}
