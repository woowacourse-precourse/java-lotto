package lotto.service;

import lotto.entity.Lotto;

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
}
