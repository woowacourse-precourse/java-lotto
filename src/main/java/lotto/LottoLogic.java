package lotto;

public class LottoLogic {
    private static final int ONE_LOTTO = 1000;
    private int money;
    private int numberOfLotto;

    public LottoLogic(int money) {
        this.money = money;
        this.numberOfLotto = calculateNumberOfLotto();
    }

    private int calculateNumberOfLotto() {
        return this.money / ONE_LOTTO;
    }

    public int getNumberOfLotto() {
        return this.numberOfLotto;
    }
}