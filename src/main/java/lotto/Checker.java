package lotto;

import java.util.HashMap;
import java.util.List;

public class Checker extends LottoKiosk {
    static final int FIRST_PRIZE_COUNT = 6;
    static final int THIRD_PRIZE_COUNT = 5;
    static final int FOURTH_PRIZE_COUNT = 4;
    static final int FIFTH_PRIZE_COUNT = 3;
    static HashMap<Integer, Enum> countMatchingPrizes = new HashMap<>() {{
        countMatchingPrizes.put(FIRST_PRIZE_COUNT, PrizeRank.first);
        countMatchingPrizes.put(THIRD_PRIZE_COUNT, PrizeRank.third);
        countMatchingPrizes.put(FOURTH_PRIZE_COUNT, PrizeRank.fourth);
        countMatchingPrizes.put(FIFTH_PRIZE_COUNT, PrizeRank.fifth);
    }};

    public static void compare(List<Lotto> buyerLottos, int buyerBonusNumber) {
        for (Lotto lotto : buyerLottos) {
            int countSameNumbers = countSameNumbers(lotto);
            resultStatistics.add(getRank().ordinal(), resultStatistics.get(getRank().ordinal()) + 1);
        }

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

    public static int drawFirstPrize(List<Integer> buyerNumbers) {
        if (buyerNumbers.equals(LottoKiosk.winningNumbers)) {
            return 1;
        }
        return 0;
    }

    public static int drawSecondPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers,) {
        return 0;
    }

    public static int drawThirdPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }

    public static int drawFourthPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }

    public static int drawFifthPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }
}

enum PrizeRank {
    first, second, third, fourth, fifth
}
