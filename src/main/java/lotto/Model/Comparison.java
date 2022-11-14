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
}
