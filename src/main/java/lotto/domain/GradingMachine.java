package lotto.domain;

public class GradingMachine {

    private final Lotto winnerLotto;
    private final int bonusNumber;

    public GradingMachine(Lotto winnerLotto, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }
}
