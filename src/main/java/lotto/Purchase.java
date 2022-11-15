package lotto;

import static lotto.utils.Messages.ERROR_PLUS_NUMBER_MESSAGE;
import static lotto.utils.Messages.ERROR_UNIT_MESSAGE;

public class Purchase {
    private final int purchase;

    public Purchase(int purchase) {
        validate(purchase);
        this.purchase = purchase;
    }

    public int getPurchase() {
        return this.purchase;
    }

    private void validate(int purchase) {
        validateRange(purchase);
        validateUnit(purchase);
    }

    private void validateRange(int purchase) {
        if(purchase<0){
            throw new IllegalArgumentException(ERROR_PLUS_NUMBER_MESSAGE);
        }
    }

    private void validateUnit(int purchase) {
        if(purchase % 1000 !=0){
            throw new IllegalArgumentException(ERROR_UNIT_MESSAGE);
        }
    }
}
