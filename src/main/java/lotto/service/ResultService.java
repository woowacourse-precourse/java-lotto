package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.WinningLotto;

public class ResultService {
    public static Result addRankResult(User user, WinningLotto winningLotto) {
        Map<Rank, Integer> results = new HashMap<>();
        for (Lotto lotto : user.getLottos()) {
            int count = compareNumbers(lotto.getNumbers(), winningLotto.getWinningNumbers());
            if (count >= 3) {
                Rank key = Rank.valueOf(count, false);
                results.put(key, results.getOrDefault(key, 0) + 1);
            }
        }
        return new Result(results);
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
}
