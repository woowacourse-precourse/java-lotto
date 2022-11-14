package lotto.application;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusBall;
import lotto.domain.LottoAmount;
import lotto.domain.WinningBalls;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @DisplayName("구입금액을 기준으로 로또 구매 개수 생성 테스트")
    @Test
    void createLottoAmount() {
        int mount = 10000;

        LottoAmount lottoAmount = new LottoAmount(mount);

        assertThat(lottoAmount.getLottoCount()).isEqualTo(10);
    }

    @DisplayName("원금과 당첨금으로 수익률 계산")
    @Test
    void calculateProfit () {
        int principal = 5000;
        int prizeMoney = 12000;

        double profit = LottoService.calculateProfit(principal,prizeMoney);

        assertThat(profit).isEqualTo(240.0);
    }

    @DisplayName("로또 구입금액과 생성된 로또 개수를 비교")
    @Test
    void createLottosByLottoAmount() {
        int lottoAmount = 5000;

        List<Lotto> lottos = LottoService.getLottos(lottoAmount);

        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("로또와 당첨번호, 보너스 번호가 올바르게 비교되는지 테스트")
    @Test
    void matchLotto() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls =  new Balls(winningBalls, bonusBall);
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(Arrays.asList(1,2,3,4,5,8));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1,lotto2,lotto3));

        List<Match> matches = LottoService.match(lottos, balls);

        assertThat(matches).isEqualTo(Arrays.asList(Match.SIX_MATCH, Match.FIVE_BONUS_MATCH, Match.FIVE_MATCH));
    }

    @DisplayName("보너스 번호가 매치되어도 2등의 경우가 아니라면 정상 실행")
    @Test
    void matchBonusNumberExclude2nd() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls =  new Balls(winningBalls, bonusBall);

        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,7,8));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1));

        List<Match> matches = LottoService.match(lottos, balls);

        assertThat(matches).isEqualTo(Arrays.asList(Match.FOUR_MATCH));
    }

}