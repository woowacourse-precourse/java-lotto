package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("8개를 구매하면, 구매한 총 가격인 8000을 반환한다.")
    @Test
    void returnTotalPricesOfPurchase1() {
        LottoTickets lottoTickets = new LottoTickets(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );
        int actual = lottoTickets.totalPayment();
        int predict = 8_000;
        Assertions.assertThat(actual).isEqualTo(predict);
    }

    @DisplayName("당첨 번호와 보너스 번호를 받고, 당첨된 로또에 한해 List<Ranking>을 반환 해준다.")
    @Test
    void createRankingList() {
        LottoTickets lottoTickets = new LottoTickets(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                        new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                        new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                        new Lotto(List.of(15, 22, 33, 10, 11, 12))
                )
        );

        List<Ranking> rankings = lottoTickets.rankings(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        Assertions.assertThat(rankings).hasSize(5);
    }

    @DisplayName("당첨 번호와 보너스 번호를 받고, 당첨되지 않은 경우, 빈 리스트를 반환한다.")
    @Test
    void createRankingList2() {
        LottoTickets lottoTickets = new LottoTickets(
                List.of(new Lotto(List.of(15, 22, 33, 10, 11, 12)))
        );

        List<Ranking> rankings = lottoTickets.rankings(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        Assertions.assertThat(rankings).hasSize(0);
    }
}