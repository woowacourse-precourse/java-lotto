package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.WinningLotto;

public class ResultService {
    public static Result addRankResult(User user, WinningLotto winningLotto) {
        Result result = new Result(new LinkedHashMap<>());
        for (Lotto lotto : user.getLottos()) {
            List<Integer> userNumbers = lotto.getNumbers();
            int count = compareNumbers(userNumbers, winningLotto.getWinningNumbers());
            boolean isBonus = checkBonusNumber(userNumbers, winningLotto.getBounsNumber());
            if (count >= 3) {
                Rank key = Rank.valueOf(count, isBonus);
                result.getResults().put(key, result.getResults().getOrDefault(key, 0) + 1);
            }
        }
        return result;
    }

    private static boolean checkBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        for (int userNumber : userNumbers) {
            if (userNumber == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    private static int compareNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (winningNumbers.contains(userNumber)) {
                count += 1;
            }
        }
        return count;
    }

    public static double getProfitRate(User user, Result result) {
        int amount = user.getAmount();
        int totalProfit = getTotalProfit(result);
        return totalProfit / (double) amount * 100;
    }

    private static int getTotalProfit(Result result) {
        int totalProfit = 0;
        Map<Rank, Integer> results = result.getResults();
        for (Rank rank : result.getResults().keySet()) {
            if (rank == Rank.NONE) {
                continue;
            }
            totalProfit += rank.getMoney() * result.getResults().get(rank);
        }
        return totalProfit;
    }
}
