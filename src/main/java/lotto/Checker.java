package lotto;

import enumCollections.RankIndex;
import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.HashMap;
import java.util.List;

public class Checker extends Kiosk {
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

    public static void compare(List<Lotto> buyerLottos) {
        for (Lotto lotto : buyerLottos) {
            Enum lottoRank = getRank(countSameNumbers(lotto));
            if (lottoRank.equals(RankIndex.THIRD) && hasBonusNumber(lotto)) {
                lottoRank = RankIndex.SECOND;
            }
            resultStatistics[lottoRank.ordinal()]++;
        }
    }

    public static boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public static int countSameNumbers(Lotto lotto) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public static Enum getRank(int countSameNumbers) {
        HashMap<Integer, Enum> countMatchingPrizes = createNumberMatchingRanks();
        return countMatchingPrizes.get(countSameNumbers);
    }

    public static float getYield(int payment) {
        return (getTotalWinnings() / payment) * 100;
    }

    public static float getRoundedYield(float yield) {
        return Math.round(yield * 100) / 100.0f;
    }

    public static int getTotalWinnings() {
        int totalWinnings = 0;
        for (RankIndex rank : RankIndex.values()) {
            totalWinnings += resultStatistics[rank.ordinal()] * Winnings.getAmount(rank.name());
        }
        return totalWinnings;
    }

}