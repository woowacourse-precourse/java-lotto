package lotto.application;

import java.util.List;
import lotto.domain.Balls;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Match;
import lotto.domain.WinningBalls;

public interface LottoService {

    LottoAmount getLottoAmount(int lottoAmount);

    List<Lotto> getLottos(LottoAmount lottoAmount);

    Balls getBalls(WinningBalls winningBalls, BonusBall bonusBall);

    List<Match> match(List<Lotto> lottos, Balls balls);

    double calculateProfit(int principal, long prizeMoney);
}
