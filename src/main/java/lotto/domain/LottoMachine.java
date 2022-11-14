package lotto.domain;

import lotto.enumeration.Ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.enumeration.Ranking.*;

public class LottoMachine {
    private final int LOTTO_UNIT = 1000;

    public Lottos purchase(PurchaseMoney purchaseMoney) {
        int purchaseNumber = countPurchaseNumber(purchaseMoney);

        return new Lottos(purchaseNumber);
    }

    public static WinningList compute(Lottos lottos, TotalPrizeNumbers totalPrizeNumbers) {
        Map<Ranking, Integer> winningList = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            Ranking ranking = determineRanking(lotto, totalPrizeNumbers);
            winningList.put(ranking, winningList.getOrDefault(ranking, 0) + 1);
        }
        return new WinningList(winningList);
    }

    private static Ranking determineRanking(Lotto lotto, TotalPrizeNumbers totalPrizeNumbers) {
        int equalNormalNumberCount = getEqualCount(lotto, totalPrizeNumbers);
        boolean isBonusEqual = ckeckBonusEqual(lotto, totalPrizeNumbers);

        return Ranking.create(equalNormalNumberCount, isBonusEqual);
    }

    private static int getEqualCount(Lotto lotto, TotalPrizeNumbers totalPrizeNumbers) {
        List<PrizeNumber> normalNumbers = totalPrizeNumbers.getNormalNumbers();
        return (int) normalNumbers.stream()
                .map(PrizeNumber::getPrizeNumber)
                .filter(lotto::checkContainPrizeNumber)
                .count();
    }

    private static boolean ckeckBonusEqual(Lotto lotto, TotalPrizeNumbers totalPrizeNumbers) {
        int bonusNumber = totalPrizeNumbers.getBonusNumber();
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int countPurchaseNumber(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getPrice() / LOTTO_UNIT;
    }

    public static Double caculateRateOfProfit(WinningList winningList, PurchaseMoney purchaseMoney) {
        Map<Ranking, Integer> winningInfo = winningList.getWinningInfo();
        Long profit = caculateProfit(winningInfo);
        return (double) profit / (double) purchaseMoney.getPrice() * 100;
    }

    private static Long caculateProfit(Map<Ranking, Integer> winningInfo) {
        return winningInfo.getOrDefault(FIFTH,0) * FIFTH.getPrizeMoney()
                + winningInfo.getOrDefault(FORTH, 0) * FORTH.getPrizeMoney()
                + winningInfo.getOrDefault(THIRD, 0) * THIRD.getPrizeMoney()
                + winningInfo.getOrDefault(SECOND, 0) * SECOND.getPrizeMoney()
                + winningInfo.getOrDefault(FIRST, 0) * FIRST.getPrizeMoney();
    }
}
