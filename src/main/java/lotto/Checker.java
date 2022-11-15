package lotto;

import enumCollections.RankNumber;

import java.util.EnumMap;
import java.util.List;

public class Checker {
    static EnumMap<RankNumber, Integer> resultStatistics;
    static List<Integer> winningNumbers;
    static int bonusNumber;

    public static EnumMap<RankNumber, Integer> compareAllLottos(
            Buyer buyer,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        Checker.winningNumbers = winningNumbers;
        Checker.bonusNumber = bonusNumber;
        resultStatistics = initializeResultStatistics();
        for (Lotto lotto : buyer.lottos) {
            if (isInRankRange(lotto)) {
                compareLotto(lotto);
            }
        }
        return resultStatistics;
    }

    private static EnumMap<RankNumber, Integer> initializeResultStatistics() {
        EnumMap<RankNumber, Integer> emptyResultStatistics = new EnumMap<>(RankNumber.class);
        for (RankNumber rank : RankNumber.values()) {
            emptyResultStatistics.put(rank, 0);
        }
        return emptyResultStatistics;
    }

    private static boolean isInRankRange(Lotto lotto) {
        if (countSameNumbers(lotto) >= RankNumber.get(RankNumber.FIFTH)) {
            return true;
        }
        return false;
    }

    private static void compareLotto(Lotto lotto) {
        int sameNumbers = countSameNumbers(lotto);
        RankNumber rank = getRank(sameNumbers);
        if (rank.equals(RankNumber.THIRD) && hasBonusNumber(lotto)) {
            rank = RankNumber.SECOND;
        }
        updateCounts(rank);
    }

    private static int countSameNumbers(Lotto lotto) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private static RankNumber getRank(int sameNumbers) {
        return RankNumber.getRank(sameNumbers);
    }

    private static boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private static void updateCounts(RankNumber rank) {
        int oldCounts = resultStatistics.get(rank);
        resultStatistics.put(rank, oldCounts + 1);
    }
}