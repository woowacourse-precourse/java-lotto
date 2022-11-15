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

public class LottoServiceImpl implements LottoService {

    private final LottoProvider lottoProvider;

    public LottoServiceImpl(LottoProvider lottoProvider) {
        this.lottoProvider = lottoProvider;
    }

    @Override
    public LottoAmount getLottoAmount(int lottoAmount) {
        return new LottoAmount(lottoAmount);
    }

    @Override
    public List<Lotto> getLottos(LottoAmount lottoAmount) {
        return lottoProvider.createLottos(lottoAmount.getLottoCount());
    }

    @Override
    public Balls getBalls(WinningBalls winningBalls, BonusBall bonusBall) {
        return new Balls(winningBalls, bonusBall);
    }

    @Override
    public List<Match> match(List<Lotto> lottos, Balls balls) {
        return lottos.stream()
                .map(lotto -> lotto.match(balls))
                .collect(Collectors.toList());
    }

    @Override
    public double calculateProfit(int principal, long prizeMoney) {
        return (prizeMoney * 100.0) / principal;
    }



}
