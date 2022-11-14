package lotto;

import static util.Constant.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private int prize;
    private Map<Rank, Integer> result;

    public Result() {
        this.prize = 0;
        this.result = new LinkedHashMap<>();
    }

    // 모든 구매한 로또와 당첨 로또를 비교해 결과를 도출하는 기능
    public void matchLottoAndWinningLotto(Lottos lottos, Lotto winngingLotto, Bonus bonus) {
        initWinningRank();
        for (Lotto lotto : lottos.getLottos()) {
            updateResult(checkMatchCount(lotto, winngingLotto), matchBonus(lotto, bonus.getBonus()));
        }
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

    // 등수로 결과 map을 초기화 하는 기능
    public void initWinningRank() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    // 수익률을 산출하는 기능
    public String calculateYield(int money) {
        BigDecimal totalPrize = BigDecimal.valueOf(getTotalPrize());
        BigDecimal purchaseMoney = BigDecimal.valueOf(money);
        BigDecimal percent = new BigDecimal(PERCENT);
        BigDecimal yield = totalPrize.divide(purchaseMoney).multiply(percent);
        return String.format(ROUND_SECOND_DECIMAL_PLACE, yield);
    }

    // 총 상금을 산출하는 기능
    public int getTotalPrize() {
        for (Rank rank : result.keySet()) {
            prize += rank.getPrize() * result.get(rank);
        }
        return prize;
    }

    // 결과를 반환하는 기능
    public Map<Rank, Integer> getResult() {
        return result;
    }
}
