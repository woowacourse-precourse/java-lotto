package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoGenerator.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoGenerator.MINIMUM_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    
    @RepeatedTest(10)
    @DisplayName("generate 테스트")
    void test() {
        //given
        Money money = new Money(5000);

        //when
        LottoTickets lottoTickets = LottoGenerator.generateTickets(money);
        List<Lotto> res = lottoTickets.getLottoTickets();

        //then
        assertThat(res.size()).isEqualTo(money.getTicketCount());

        for (Lotto lottoTicket : res) {
            List<Integer> numbers = lottoTicket.getNumbers();

            assertThat(numbers.size()).isEqualTo(LOTTO_NUMBER_COUNT);

            for (Integer num : numbers) {
                assertThat(num).isGreaterThanOrEqualTo(MINIMUM_LOTTO_NUMBER);
                assertThat(num).isLessThanOrEqualTo(MAXIMUM_LOTTO_NUMBER);
            }
        }
    }
}