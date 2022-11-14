package lotto;

import enumCollections.RankNumber;

import java.util.EnumMap;

public class Checker extends Kiosk {
    static EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics();

    public static EnumMap<RankNumber, Integer> compareAll(Buyer buyer) {
        for (Lotto lotto : buyer.lottos) {
            if (isInRankRange(lotto)) {
                compareEach(lotto);
            }
        }
        return resultStatistics;
    }

    public static void compareEach(Lotto lotto) {
        RankNumber lottoRank = getRank(countSameNumbers(lotto));
        if (lottoRank.equals(RankNumber.THIRD) && hasBonusNumber(lotto)) {
            lottoRank = RankNumber.SECOND;
        }
        int oldCounts = resultStatistics.get(lottoRank);
        resultStatistics.put(lottoRank, oldCounts + 1);
    }

    public static boolean isInRankRange(Lotto lotto) {
        if (countSameNumbers(lotto) >= RankNumber.getRankNumber(RankNumber.FIFTH)) {
            return true;
        }
        return false;
    }

    public static EnumMap<RankNumber, Integer> initializeResultStatistics() {
        EnumMap<RankNumber, Integer> emptyResultStatistics = new EnumMap<RankNumber, Integer>(RankNumber.class);
        for (RankNumber rank : RankNumber.values()) {
            emptyResultStatistics.put(rank, 0);
        }
        return emptyResultStatistics;
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

    public static RankNumber getRank(int sameNumbers) {
        return RankNumber.getRank(sameNumbers);
    }
}