package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {


    @Test
    @DisplayName("generate 테스트")
    void test() {
        //given
        int expectMinNum = 1;
        int expectMaxNum = 45;
        int expectSize = 6;
        Money money = new Money(5000);

        //when
        LottoTickets lottoTickets = LottoGenerator.generateTickets(money);
        List<LottoTicket> res = lottoTickets.getLottoTickets();

        //then
        assertThat(res.size()).isEqualTo(money.getTicketCount());

        for (LottoTicket lottoTicket : res) {
            List<Integer> numbers = lottoTicket.getNumbers();

            assertThat(numbers.size()).isEqualTo(expectSize);

            for (Integer num : numbers) {
                assertThat(num).isGreaterThanOrEqualTo(expectMinNum);
                assertThat(num).isLessThanOrEqualTo(expectMaxNum);
            }
        }
    }
}