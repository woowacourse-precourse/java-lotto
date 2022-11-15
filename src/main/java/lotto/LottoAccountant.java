package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoAccountant {
    private LottoResultMaker lottoResultMaker;

    public LottoAccountant(LottoResultMaker lottoResultMaker) {
        this.lottoResultMaker = lottoResultMaker;
    }

    public List<LottoResult> getLottoResults(WinningLotto winningLotto, List<Lotto> userLottos) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto userLotto : userLottos) {
            lottoResults.add(lottoResultMaker.getLottoResult(winningLotto, userLotto));
        }

        return lottoResults;
    }

    public LottoStats getNumberMatchStats(List<LottoResult> lottoResults) {
        LottoStats lottoStats = new LottoStats();

        for (LottoResult lottoResult : lottoResults) {
            lottoStats.setNumberMatchCounts(lottoResult.getNumberMatchCount(), lottoResult.isBonusNumberMatch());
        }

        return lottoStats;
    }

    public Float getRateOfReturn(LottoStats lottoStats, int lottoPrice) {
        Long totalWinnings = lottoStats.calculateTotalWinnings();

        return (float) totalWinnings / (float) (lottoStats.getLottoCount() * lottoPrice) * 100;
    }
}
