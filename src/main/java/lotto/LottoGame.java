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
        printLottoGameResult(lottoGameResult);
    }

    private void printLottoGameResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            Integer count = lottoGameResult.getLottoRankingCount()
                .getOrDefault(lottoRanking, 0);
            lottoRanking.printMessage(count);
        }
        System.out.printf("총 수익률은 %.1f%s입니다.", lottoGameResult.getProfitRatio(), "%");
    }

    private List<LottoRanking> findLottoRankings() {
        List<LottoRanking> lottoRankings = new ArrayList<>();
        for (Lotto lotto: buyer.getLottos()) {
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
