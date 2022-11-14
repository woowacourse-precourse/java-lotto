package lotto.service;

import lotto.dto.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Profit;
import lotto.vo.WinningInfo;

import java.util.List;

public interface LottoService {
    List<Lotto> createLottos(LottoBuyingInfo lottoBuyingInfo);

    ScoreInfo makeScoreInfoBy(List<Lotto> lottos, WinningInfo winningInfo);

    Profit calculateProfitBy(LottoBuyingInfo lottoBuyingInfo, ScoreInfo scoreInfo);
}
