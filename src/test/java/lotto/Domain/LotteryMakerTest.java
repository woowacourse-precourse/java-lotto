package lotto.Domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMakerTest {
    private  static LotteryMaker lotteryMaker;
    @BeforeAll
    static void initAll(){
        lotteryMaker = new LotteryMaker();
    }

    @DisplayName("하나의 로또지가 제대로 발행되는지 검증")
    @Test
    void publishLotteryTicketsTest(){
        // given
        List<Integer> ticket = lotteryMaker.publishLotteryTicket();
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
        // given
        int lotteryAmount = 1;
        // when
        lotteryMaker.issueLotteryTickets(lotteryAmount);
        // then
        List<Lotto> tickets = lotteryMaker.getLotteryTickets();
        assertThat(tickets.size()).isEqualTo(lotteryAmount);
    }

}
