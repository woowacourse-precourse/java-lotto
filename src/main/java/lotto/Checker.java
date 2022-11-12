package lotto;

import enumCollections.RankIndex;
import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.HashMap;
import java.util.List;

public class Checker extends Kiosk {
    static final int FIRST_PRIZE_COUNT = 6;
    static final int THIRD_PRIZE_COUNT = 5;
    static final int FOURTH_PRIZE_COUNT = 4;
    static final int FIFTH_PRIZE_COUNT = 3;

    static HashMap<Integer, RankIndex> countMatchingPrizes = new HashMap<>() {
        {
            put(FIRST_PRIZE_COUNT, RankIndex.FIRST);
            put(THIRD_PRIZE_COUNT, RankIndex.THIRD);
            put(FOURTH_PRIZE_COUNT, RankIndex.FOURTH);
            put(FIFTH_PRIZE_COUNT, RankIndex.FIFTH);
        }
    };

    public HashMap<Integer, Integer> createNumberMatchingRanks() {
        HashMap<Integer, Integer> countMatchingPrizes = new HashMap<>();
        for (RankNumber rank : RankNumber.values()) {
            countMatchingPrizes.put(
                    RankNumber.getRankNumber(rank),
                    RankIndex.getRankIndex(rank.name())
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