package lotto;

import static lotto.ExceptionMessage.*;

public class LottoAmount {

    private int amount;

    public LottoAmount(String purchaseAmount) {
        validate(purchaseAmount);
        this.amount = Integer.parseInt(purchaseAmount) / 1000;

    }

    public void validate(String line) {
        String data = "";
        for (char x : line.toCharArray()) {
            if (!Character.isDigit(x)) {

                throw new IllegalArgumentException(PURCHASE_INPUT_ERROR);
            }
        }

        if ((Integer.parseInt(line)) % 1000 != 0) {

            throw new IllegalArgumentException(PURCHASE_ERROR);
        }

    }

    public int getAmount() {
        return amount;
    }
}
