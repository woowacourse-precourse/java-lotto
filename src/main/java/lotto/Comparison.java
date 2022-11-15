package lotto;

import java.util.*;

public class Comparison {
    public enum Result {
        THREE(3, 0,5_000),
        FOUR(4, 0,50_000),
        FIVE(5, 0,1_500_000),
        FIVE_WITH_BONUS(5,1, 30_000_000),
        SIX(6,0, 2_000_000_000);

        private final Integer count;
        private final Integer bonus;
        private final Integer cash;
        Result(Integer count, Integer bonus, Integer cash) {
            this.count = count;
            this.bonus = bonus;
            this.cash = cash;
        }

        public Integer getCount() {
            return count;
        }
        public Integer getBonus() {return bonus;}
        public Integer getCash() {return cash;}
    }

    public static Map<Result, Integer> results;
    public static final Integer BONUS_COUNT = 5;

    public static Map<Result, Integer> getResults() {
        return results;
    }

    public static void createResults() {
        Map<Result, Integer> newResult = new HashMap<>();
        Arrays.stream(Result.values()).forEach(result -> newResult.put(result, 0));
        results = newResult;
    }

    public static void createResult(User user, WinningLotto winningLotto) {
        List<List<Integer>> userLottos = user.getLottos();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        Integer winningLottoBonusNumber = winningLotto.getBonusNumber();

        for (List<Integer> userLotto: userLottos) {
            compareLottoNumbers(userLotto, winningLottoNumbers, winningLottoBonusNumber);
        }
        results.entrySet().stream().sorted(Map.Entry.comparingByKey());
    }

    public static void compareLottoNumbers(
           List<Integer> userLotto, List<Integer> winningLotto, Integer winningBonusNumber
    ) {
        int bonus = 0;
        int count = (int) userLotto.stream().filter(winningLotto::contains).count();
        if (count == BONUS_COUNT && hasBonusNumber(userLotto, winningBonusNumber)) {
            bonus++;
        }
        createResults();
        for (Result result: Result.values()) {
            if (isExist(result, count, bonus)) {
                results.put(result, results.get(result) + 1);
            }
        }
    }

    public static boolean hasBonusNumber(List<Integer> userLotto, Integer winningBonusNumber) {
        return userLotto.contains(winningBonusNumber);
    }

    public static boolean isExist(Result result, Integer count, Integer bonus) {
        return Objects.equals(result.getCount(), count) && Objects.equals(result.getBonus(), bonus);
    }
}
