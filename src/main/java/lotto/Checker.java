package lotto;

import enumCollections.RankIndex;
import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.HashMap;
import java.util.List;

public class Checker extends Kiosk {
    public static int[] compare(Buyer buyer) {
        int[] resultStatistics = initializeResultStatistics();
        for (Lotto lotto : buyer.lottos) {
            Enum lottoRank = getRank(countSameNumbers(lotto));
            if (lottoRank.equals(RankIndex.THIRD) && hasBonusNumber(lotto)) {
                lottoRank = RankIndex.SECOND;
            }
            resultStatistics[lottoRank.ordinal()]++;
        }
        return resultStatistics;
    }

    private static int[] initializeResultStatistics() {
        return new int[]{0, 0, 0, 0, 0, 0};
    }

    public static boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public static int countSameNumbers(Lotto lotto) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.hasNumber(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public static Enum getRank(int countSameNumbers) {
        HashMap<Integer, Enum> countMatchingPrizes = createNumberMatchingRanks();
        return countMatchingPrizes.get(countSameNumbers);
    }

    public static HashMap<Integer, Enum> createNumberMatchingRanks() {
        HashMap<Integer, Enum> countMatchingPrizes = new HashMap<>();
        for (RankNumber rank : RankNumber.values()) {
            countMatchingPrizes.put(
                    RankNumber.getRankNumber(rank),
                    RankIndex.valueOf(rank.name())
            );
        }
        return countMatchingPrizes;
    }
}