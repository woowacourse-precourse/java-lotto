package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class WinLottoTest {

    @DisplayName("결과를 조회하여 순위에 해당하는 결과가 올바르게 집계되는지 확인")
    @Test
    void getResultByLotteries() {
        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Lotto winnerNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinLotto winLotto = new WinLotto(lotteries, winnerNumber, bonusNumber);
        Map<LottoRank, Integer> lottoRankIntegerMap = winLotto.getResult();
        Assertions.assertThat(lottoRankIntegerMap.get(LottoRank.FIRST)).isEqualTo(2);
    }

    @DisplayName("당첨로또들의 수익을 알맞게 집계하는지 확인")
    @Test
    void getProfitByWinLotto() {
        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Lotto winnerNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinLotto winLotto = new WinLotto(lotteries, winnerNumber, bonusNumber);
        Assertions.assertThat(winLotto.getProfit()).isEqualTo(2_030_000_000);
    }

}