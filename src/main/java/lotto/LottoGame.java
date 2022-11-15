package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.buyer.Buyer;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRanking;
import lotto.domain.seller.Seller;
import lotto.dto.LottoCount;
import lotto.dto.LottoGameResult;
import lotto.ui.UI;

public class LottoGame {

    private final Buyer buyer;
    private final Seller seller;

    public LottoGame(Buyer buyer, Seller seller) {
        this.buyer = buyer;
        this.seller = seller;
    }

    public void start() {
        List<LottoRanking> lottoRankings = findLottoRankings();
        Map<LottoRanking, Integer> lottoRankingCount = findLottoRankingCount(lottoRankings);
        int totalWinningAmount = seller.calculateTotalWinningAmount(lottoRankings);
        double profitRatio = buyer.calculateProfitRatio(totalWinningAmount);
        LottoGameResult lottoGameResult = new LottoGameResult(lottoRankings, lottoRankingCount,
            profitRatio);

        UI.printLottoGameResult(lottoGameResult);
    }

    private List<LottoRanking> findLottoRankings() {
        List<LottoRanking> lottoRankings = new ArrayList<>();
        for (Lotto lotto : buyer.getLottos()) {
            int hits = seller.compareNumbers(lotto.getNumbers());
            boolean bonus = seller.compareBonusNumber(lotto.getNumbers());
            LottoRanking lottoRanking = LottoRanking.of(new LottoCount(hits, bonus));
            lottoRankings.add(lottoRanking);
        }
        return lottoRankings;
    }

    private Map<LottoRanking, Integer> findLottoRankingCount(List<LottoRanking> lottoRankings) {
        Map<LottoRanking, Integer> lottoRankingCount = new HashMap<>();
        for (LottoRanking lottoRanking : lottoRankings) {
            lottoRankingCount.put(lottoRanking,
                lottoRankingCount.getOrDefault(lottoRanking, 0) + 1);
        }
        return lottoRankingCount;
    }
}
