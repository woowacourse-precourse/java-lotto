package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private int prize;
    private Map<Rank, Integer> result;

    public Result() {
        this.prize = 0;
        this.result = new HashMap<>();
    }

    // 당첨 번호와 로또 번호를 비교하여 같은 수의 개수를 반환하는 기능
    public int checkMatchCount(Lotto lotto, Lotto winningLotto) {
        List<Integer> purchasedLottoNumbers = lotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int matchCount = 0;
        for (Integer number : purchasedLottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
