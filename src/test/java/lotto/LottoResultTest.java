package lotto;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottoResultTest {

    @DisplayName("당첨 결과를 생성한다.")
    @Test
    public void createLottoResult() {
        // create lotto
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);

        Lottos lottos = new Lottos(Arrays.asList(firstLotto, secondLotto));

        // create winningLotto
        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Lotto winLotto = new Lotto(winningLottoNumber);

        WinningLotto winningLotto = new WinningLotto(winLotto, bonus);

        // create lottoWinResult
        LottoResult lottoResult = lottos.getLottoResult(winningLotto);

        assertThat(lottoResult.getCountOfLottoResult(LottoRank.FIRST_PLACE)).isEqualTo(1);
        assertThat(lottoResult.getCountOfLottoResult(LottoRank.SECOND_PLACE)).isEqualTo(1);
    }

    @DisplayName("총 당첨금을 구한다.")
    @Test
    public void getTotalWinnings() {
        // create lotto
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);

        Lottos lottos = new Lottos(Arrays.asList(firstLotto, secondLotto));

        // create winningLotto
        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Lotto winLotto = new Lotto(winningLottoNumber);

        WinningLotto winningLotto = new WinningLotto(winLotto, bonus);

        // create lottoWinResult
        LottoResult lottoResult = lottos.getLottoResult(winningLotto);

        assertThat(lottoResult.getLottoTotalMoney()).isEqualTo(2030000000);
    }
}
