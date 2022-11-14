package lotto.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparison {

    private Map<String, Integer> savedResult = new HashMap<>();

    public void compareLotto(List<Lotto> lottoNumber, WinningTicket ticket) {
        for (Lotto lotto : lottoNumber) {
            boolean bonusCheck = false;
            int sum = compareLottoNum(lotto.getNumbers(), ticket.getWinningTicket());
            if (sum == 5) {
                bonusCheck = compareLottoNum(lotto.getNumbers(), ticket.getBonusNum());
            }
            if (sum > 2) {
                saveResult(sum, bonusCheck);
            }
        }
    }

    private boolean compareLottoNum(List<Integer> numbers, int bonusNum) {
        if (numbers.contains(bonusNum)) {
            return true;
        }
        return false;
    }

    private int compareLottoNum(List<Integer> numbers, Lotto ticket) {
        int count = 0;
        for (int num : ticket.getNumbers()) {
            if (numbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    private void saveResult(int sum, boolean bonusCheck) {
        if(sum == 5 && bonusCheck) {
            savedResult.put("5B", savedResult.getOrDefault("5B", 0) + 1);
            return;
        }
        String key = Integer.toString(sum);
        savedResult.put(key, savedResult.getOrDefault(key,0)+1);
    }

    public Map<String, Integer> getSavedResult() {
        return savedResult;
    }
}
