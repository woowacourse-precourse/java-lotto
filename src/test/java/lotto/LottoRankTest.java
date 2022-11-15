package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistic;
import lotto.domain.LottoWinNumbers;

import lotto.domain.Lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("1등을 맞추었을 때 LottoRank FIRST 의 winCount 카운트가 1로 올라감")
    @Test
    void caseFirstPrize(){
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(List.of(1,2,3,4,5,6));
        lottoWinNumbers.setBonus(7);

        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,6)));

        LottoStatistic.computeLottoRank(lottos, lottoWinNumbers);

        assertThat(LottoRank.FIRST.getWinCount()).isEqualTo(1);
    }

    @DisplayName("1등과 2등이 당첨되었을 경우 LottoRank FIRST 와 SECOND winCount 카운트가 1로 올라감")
    @Test
    void caseFirstPrizeSecondPrize(){
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(List.of(1,2,3,4,5,6));
        lottoWinNumbers.setBonus(7);

        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,7)));

        LottoStatistic.computeLottoRank(lottos, lottoWinNumbers);

        assertThat(LottoRank.FIRST.getWinCount()).isEqualTo(1);
        assertThat(LottoRank.SECOND.getWinCount()).isEqualTo(1);
    }

}
