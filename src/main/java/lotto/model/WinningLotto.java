package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bounsNumber;

    public WinningLotto(Lotto lotto, Integer bounsNumber) {
        this.lotto = lotto;
        this.bounsNumber = bounsNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBounsNumber() {
        return bounsNumber;
    }
}
