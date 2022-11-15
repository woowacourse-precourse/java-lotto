package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.domain.lotto.Lotto;
import lotto.domain.lottoResult.LottoStatistic;
import lotto.domain.lotto.LottoWinNumbers;
import lotto.domain.lottoResult.LottoYield;
import lotto.domain.lotto.Lottos;


public class LottoYieldTest {
    @DisplayName("8000원 구매 후 3등 한개 당첨시 수익율 62.5%")
    @Test
    void caseFirstPrize(){
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(List.of(1,2,3,4,5,6));
        lottoWinNumbers.setBonus(7);

        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,41,35,26)));

        LottoStatistic.computeLottoRank(lottos, lottoWinNumbers);

        assertThat(LottoYield.computeYield(8000)).isEqualTo(62.5);
    }
}
