package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusBall;
import lotto.domain.WinningBalls;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Match;
import lotto.domain.Balls;
import lotto.infrastructure.LottoProvider;

public class LottoService {

    public static LottoAmount getLottoAmount(int lottoAmount) {
        return new LottoAmount(lottoAmount);
    }

    public static List<Lotto> getLottos(int purchaseAmount) {
        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);
        return LottoProvider.createLottos(lottoAmount.getLottoCount());
    }

    public static Balls getBalls(WinningBalls winningBalls, BonusBall bonusBall) {
        return new Balls(winningBalls, bonusBall);
    }

    public static List<Match> match(List<Lotto> lottos, Balls balls) {
        return lottos.stream()
                .map(lotto -> lotto.match(balls))
                .collect(Collectors.toList());
    }

    public static double calculateProfit(int principal, long prizeMoney) {
        return (prizeMoney * 100.0) / principal;
    }



}
