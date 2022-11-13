package lotto.domain;

public class PurchasedAmount {
    private int price;

    public PurchasedAmount(String inputPrice) {
        validate(inputPrice);
        this.price = Integer.parseInt(inputPrice);
    }

    private void validate(String inputPrice) {
        /*숫자 검사*/
        if (!validateFormat(inputPrice)) {
            throw new IllegalArgumentException();
        }

        if (!validateMinimum(inputPrice)) {
            throw new IllegalArgumentException();
        }

        if (!validateUnit(inputPrice)) {
            throw new IllegalArgumentException();
        }
    }
}
