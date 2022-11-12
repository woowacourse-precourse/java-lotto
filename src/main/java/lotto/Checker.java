package lotto;

import java.util.HashMap;
import java.util.List;

public class Checker extends LottoKiosk {
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
        return lotto.contains(winningBonusNumber);
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
