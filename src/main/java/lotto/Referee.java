package lotto;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    public static Map<Integer, Integer> compare(int bonusNumber, List<Integer> winningLotto, List<Lotto> userLotto) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            result.put(i, 0);
        }

        for (int i = 0; i < userLotto.size(); i++) {
            Lotto lottoClass = userLotto.get(i);
            List<Integer> user = lottoClass.get();
            System.out.println(user);

            int correctNumber = Judgment.correctCount(winningLotto, user);

            if (correctNumber == 6) {
                result.replace(correctNumber + 1, result.get(correctNumber + 1) + 1);
                continue;
            }

            if (correctNumber == 5 && Judgment.hasBonusNumber(bonusNumber, user)) {
                result.replace(correctNumber + 1, result.get(correctNumber + 1) + 1);
                continue;
            }

            result.replace(correctNumber, result.get(correctNumber) + 1);
        }

        return result;
    }
}
