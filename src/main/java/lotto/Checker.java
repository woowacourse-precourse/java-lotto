package lotto;

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

    public static int getTotalWinnings() {
        int totalWinnings = 0;
        HashMap<PrizeRank, Integer> winnings = initializeWinnings();
        for (PrizeRank rank : PrizeRank.values()) {
            totalWinnings += resultStatistics[rank.ordinal()] * Winnings.getAmount(rank.name());
        }
        return totalWinnings;
    }

    public static HashMap<PrizeRank, Integer> initializeWinnings() {
        HashMap<PrizeRank, Integer> winnings = new HashMap<>();
        for (PrizeRank rank : PrizeRank.values()) {
            winnings.put(rank, Winnings.getAmount(rank.name()));
        }
        return winnings;
    }
}

enum Winnings {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int amount;

    Winnings(int amount) {
        this.amount = amount;
    }

    static public int getAmount(String rank) {
        return Winnings.valueOf(rank).amount;
    }
}

enum PrizeRank {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4);

    private final int ranks;

    PrizeRank(int ranks) {
        this.ranks = ranks;
    }

    public static PrizeRank getPrizeIndex(String prizeRank) {
        return PrizeRank.valueOf(prizeRank);
    }

    public static int getPrizeIndex(PrizeRank prizeRank) {
        return prizeRank.ordinal();
    }
}
