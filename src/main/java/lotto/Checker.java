package lotto;

import enumCollections.PrizeRank;
import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.HashMap;
import java.util.List;

public class Checker extends Kiosk {
    static final int FIRST_PRIZE_COUNT = 6;
    static final int THIRD_PRIZE_COUNT = 5;
    static final int FOURTH_PRIZE_COUNT = 4;
    static final int FIFTH_PRIZE_COUNT = 3;

    static HashMap<Integer, PrizeRank> countMatchingPrizes = new HashMap<>() {
        {
            put(FIRST_PRIZE_COUNT, PrizeRank.FIRST);
            put(THIRD_PRIZE_COUNT, PrizeRank.THIRD);
            put(FOURTH_PRIZE_COUNT, PrizeRank.FOURTH);
            put(FIFTH_PRIZE_COUNT, PrizeRank.FIFTH);
        }
    };

    public static void compare(List<Lotto> buyerLottos) {
        for (Lotto lotto : buyerLottos) {
            Enum lottoRank = getRank(countSameNumbers(lotto));
            if (lottoRank.equals(PrizeRank.THIRD) && hasBonusNumber(lotto)) {
                lottoRank = PrizeRank.SECOND;
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
        for (PrizeRank rank : PrizeRank.values()) {
            totalWinnings += resultStatistics[rank.ordinal()] * Winnings.getAmount(rank.name());
        }
        return totalWinnings;
    }

}