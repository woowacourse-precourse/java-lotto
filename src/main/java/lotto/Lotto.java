package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Validators.*;

public class Lotto {
    private final List<Integer> numbers;

    private final static int LOTTERY_LENGTH = 6;
    private final static int RANGE_MIN = 1;
    private final static int RANGE_MAX = 45;
    private final static int SECOND_THIRD_MATCH = 5;
    private final static int FIFTH_MATCH = 3;

    private final static int FIRST_PRIZE = 2000000000;
    private final static int SECOND_PRIZE = 30000000;
    private final static int THIRD_PRIZE = 1500000;
    private final static int FOURTH_PRIZE = 50000;
    private final static int FIFTH_PRIZE = 5000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersUniqueness(numbers);

        validateNumbersRange(numbers);
    }

    public static List<List<Integer>> generateLotteries(int lotteryQuantity) {
        List<List<Integer>> lotteries = new ArrayList<>();

        for (int i=lotteryQuantity; i>0; i--) {
            List<Integer> lottery = pickUniqueNumbersInRange(RANGE_MIN, RANGE_MAX, LOTTERY_LENGTH);
            lotteries.add(lottery);
        }

        return lotteries;
    }

    public static List<Integer> getPrizes(List<List<Integer>> lotteries, List<Integer> jackpot, int bonus) {
        List<Integer> jackpotMatches = new ArrayList<>();
        List<Boolean> hasBonus = new ArrayList<>();

        for (List<Integer> lottery : lotteries) {
            jackpotMatches.add(compareLotteryJackpot(lottery, jackpot));
            hasBonus.add(lotteryHasBonus(lottery, bonus));
        }

        List<Integer> prizes = determinePrize(jackpotMatches, hasBonus);

        return prizes;
    }

    private static int compareLotteryJackpot(List<Integer> lottery, List<Integer> jackpot) {
        int matches = 0;

        for (Integer jackpotFigure : jackpot) {
            if (lottery.contains(jackpotFigure)) {
                matches++;
            }
        }

        return matches;
    }

    private static boolean lotteryHasBonus(List<Integer> lottery, int bonus) {
        boolean hasBonus = false;

        if (lottery.contains(bonus)) {
            hasBonus = true;
        }

        return hasBonus;
    }

    private static List<Integer> determinePrize(List<Integer> jackpotMatches, List<Boolean> hasBonus) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));

        for (int i=0; i<jackpotMatches.size(); i++) {
            int matches = jackpotMatches.get(i);
            boolean lotteryHasBonus = hasBonus.get(i);

            result = matcher(matches, result, lotteryHasBonus);
        }

        return result;
    }

    private static List<Integer> matcher(int matches, List<Integer> result, boolean lotteryHasBonus) {
        result = firstToThirdMatches(result, matches, lotteryHasBonus);
        result = fourthToFifthMatches(result, matches, lotteryHasBonus);

        return result;
    }

    private static List<Integer> firstToThirdMatches(List<Integer> result, int matches, boolean lotteryHasBonus) {
        if (matches > SECOND_THIRD_MATCH) {
            result.set(matches-2, result.get(matches-2)+1);
        }

        if (matches == SECOND_THIRD_MATCH && lotteryHasBonus) {
            result.set(matches-2, result.get(matches-2)+1);
        }

        return result;
    }

    private static List<Integer> fourthToFifthMatches(List<Integer> result, int matches, boolean lotteryHasBonus) {
        if (matches < SECOND_THIRD_MATCH && matches >= FIFTH_MATCH) {
            result.set(matches-3, result.get(matches-3)+1);
        }

        if (matches == SECOND_THIRD_MATCH && !lotteryHasBonus) {
            result.set(matches-3, result.get(matches-3)+1);
        }

        return result;
    }

    public static double getEarningRate(int budget, List<Integer> result) {
        double earningRate = 0;
        double earning = 0;
        double budgetDecimal = (double) budget;

        int[] prizes = {FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE};

        for (int i=0; i<result.size(); i++) {
            earning = earning + (prizes[i] * result.get(i));
        }

        earningRate = earning / budgetDecimal * 100;

        return earningRate;
    }
}
