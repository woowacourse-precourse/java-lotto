package lotto;

import enumCollections.RankIndex;
import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class Checker extends Kiosk {
    public static EnumMap<RankNumber, Integer> compare(Buyer buyer) {
        EnumMap<RankNumber, Integer> resultStatistics = initializeResultStatistics();
        for (Lotto lotto : buyer.lottos) {
            RankNumber lottoRank = (RankNumber)getRank(countSameNumbers(lotto));
            if (lottoRank.equals(RankNumber.THIRD) && hasBonusNumber(lotto)) {
                lottoRank = RankNumber.SECOND;
            }
            int oldCounts = resultStatistics.get(lottoRank);
            resultStatistics.put(lottoRank, oldCounts + 1);
        }
        return resultStatistics;
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

    public static Enum getRank(int sameNumbers) {
        return RankNumber.getRank(sameNumbers);
    }
}