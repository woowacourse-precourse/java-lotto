package lotto.Domain;

public class PurchasingLotto {

    private int amountOfLotto;

    public PurchasingLotto(int amountOfLotto) {
        this.amountOfLotto = amountOfLotto;
    }

    public int calculateNumberOfLotto(int purchasingAmount) {
        int NumberOfLotto = purchasingAmount / 1000;

        return NumberOfLotto;
    }
}
