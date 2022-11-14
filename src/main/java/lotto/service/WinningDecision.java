package lotto.service;

import lotto.entity.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningDecision {

    private final List<Lotto> myLotto;
    private final Lotto winningLotto;
    private final int bonus;
    private final int purchaseAmount;
    private Map<Integer, Integer> winningPrizes;

    public WinningDecision(List<Lotto> myLotto, Lotto winningLotto, int bonus, int purchaseAmount) {
        this.myLotto = myLotto;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
        this.purchaseAmount = purchaseAmount;
    }

    public void initMyPrizes() {
        winningPrizes = new HashMap<>();
        for (WinningResult result : WinningResult.values()) {
            winningPrizes.put(result.getPrize(), 0);
        }
    }

    private int getMatchingCount(List<Integer> myNumbers) {
        int cnt = 0;
        for (int myNumber : myNumbers) {
            if (winningLotto.getNumbers().contains(myNumber)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean hasBonus(List<Integer> myNumbers) {
        return myNumbers.contains(bonus);
    }
}
