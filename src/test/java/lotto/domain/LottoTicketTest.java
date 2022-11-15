package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import lotto.dto.RoundResult;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;

    @BeforeEach
    void init(){
        Lotto nothingLotto = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10));
        Lotto fifthLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto thirdLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        Lotto secondLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        List<Lotto> lottos = Arrays.asList(nothingLotto,nothingLotto,nothingLotto,fifthLotto,fifthLotto,thirdLotto,secondLotto);
        lottoTicket = new LottoTicket(lottos);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningLotto = new WinningLotto(new Lotto(winningNumbers),bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호와 대조하여 결과를 생성한다.")
    void getResultFromWinningNumbers(){
        RoundResult roundResult = lottoTicket.getResult(winningLotto);
        assertThat(roundResult.getPrizes()).containsExactly(Prize.NOTHING,Prize.NOTHING,Prize.NOTHING,Prize.FIFTH,Prize.FIFTH,Prize.THIRD, Prize.SECOND);
    }

    @Test
    @DisplayName("생성된 결과에서 수익률을 가져온다")
    void getRateOfReturn(){
        double totalPrizePrice = Prize.FIFTH.getWinnings().doubleValue()* 2L +Prize.THIRD.getWinnings().doubleValue()+Prize.SECOND.getWinnings().doubleValue();
        double expectedRateOfReturn = totalPrizePrice/ (1000.0 * lottoTicket.exportLottoNumbers().size());

        RoundResult roundResult = lottoTicket.getResult(winningLotto);
        assertThat(roundResult.getRateOfReturn()).isEqualTo(expectedRateOfReturn);
    }

}