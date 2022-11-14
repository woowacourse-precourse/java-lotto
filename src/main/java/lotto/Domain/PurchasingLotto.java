package lotto.Domain;

public class PurchasingLotto {

    private int purchase;
    private int amountOfLotto;

    public PurchasingLotto(int purchase) {
        this.purchase = purchase;
    }

    public int calculateNumberOfLotto(int purchasingAmount) {
        int NumberOfLotto = purchasingAmount / 1000;

        return NumberOfLotto;
    }
}
