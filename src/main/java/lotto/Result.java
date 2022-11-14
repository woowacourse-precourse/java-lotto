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

    // 로또 번호에 보너스 번호가 포함되어있는지 판별하는 기능
    public boolean matchBonus(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }

    //  당첨 번호와 로또 번호를 비교하여 등수를 정하는 기능
    public void updateResult(int matchCount, boolean correctBonus) {
        for (Rank rank : Rank.values()) {
            if (matchCount == rank.getCorrectCount()) {
                result.put(rank, result.get(rank) + 1);
            }
        }
        if (matchCount == Rank.SECOND.getCorrectCount() && correctBonus) {
            result.put(Rank.THIRD, result.get(Rank.THIRD) - 1);
        } else if (matchCount == Rank.THIRD.getCorrectCount()) {
            result.put(Rank.SECOND, result.get(Rank.SECOND) - 1);
        }
    }

}
