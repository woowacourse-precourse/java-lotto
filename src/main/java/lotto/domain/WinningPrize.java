package lotto.domain;// @ author ninaaano

import lotto.view.WinningResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningPrize {

    private final Lotto winningNumbers;
    private final Integer bonusNumber;
    private Map<String, Integer> totalPrize;

    public WinningPrize(List<Lotto> lottolist, Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initTotalPrize();
        checkTotalPrize(lottolist);
    }



    private void initTotalPrize() {
        totalPrize = new HashMap<>();
        for (WinningResult value : WinningResult.values()) {
            totalPrize.put(value.name(), 0);
        }
    }

    private Map<String, Integer> checkTotalPrize(List<Lotto> lottolist) {
        for (Lotto lotto : lottolist) {
            String rank = getRank(lotto);
            if (totalPrize.containsKey(rank)) {
                totalPrize.put(rank, totalPrize.get(rank) + 1);
            }
        }
        return totalPrize;
    }

    private String getRank(Lotto lotto) {
        int answerCount = getAnswerCount(lotto);
        if (answerCount == 5) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                return WinningResult.SECOND_WINNING.name();
            }
            return WinningResult.THIRD_WINNING.name();
        }
        for (WinningResult value : WinningResult.values()) {
            if (value.getWinningsCount() == answerCount) {
                return value.name();
            }
        }
        return null;
    }

    private int getAnswerCount(Lotto lotto) {
        int answerCount = 0;
        for (Integer winningNumber : winningNumbers.getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                lotto.getNumbers().remove(winningNumber);
                answerCount++;
            }
        }
        return answerCount;
    }

    public Map<String, Integer> getTotalPrize() {
        return totalPrize;
    }
}
