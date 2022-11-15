package lotto.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Constant.Constants.Number;

public class Comparison {

    private final Map<String, Integer> savedResult = new HashMap<>();

    public void compareLotto(final List<Lotto> lottoNumber, final WinningTicket ticket) {
        for (Lotto lotto : lottoNumber) {
            boolean bonusCheck = false;
            int sum = compareLottoNum(lotto.getNumbers(), ticket.getWinningTicket());
            if (sum == Number.FIVE_MATCH) {
                bonusCheck = compareLottoNum(lotto.getNumbers(), ticket.getBonusNum());
            }
            if (sum > Number.TWO_MATCH) {
                saveResult(sum, bonusCheck);
            }
        }
    }

    private boolean compareLottoNum(final List<Integer> numbers, final int bonusNum) {
        return numbers.contains(bonusNum);
    }

    private int compareLottoNum(final List<Integer> numbers, final Lotto ticket) {
        return (int) numbers.stream()
            .filter(value -> ticket.getNumbers().contains(value))
            .count();
    }

    private void saveResult(final int sum, final boolean bonusCheck) {
        if (sum == Number.FIVE_MATCH && bonusCheck) {
            savedResult.put("5B", savedResult.getOrDefault("5B", 0) + 1);
            return;
        }
        String key = Integer.toString(sum);
        savedResult.put(key, savedResult.getOrDefault(key, 0) + 1);
    }

    public Map<String, Integer> getSavedResult() {
        return savedResult;
    }
}
