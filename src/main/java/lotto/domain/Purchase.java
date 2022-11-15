package lotto.domain;

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
            System.out.println(ERROR_PLUS_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int purchase) {
        if(purchase % 1000 !=0){
            System.out.println(ERROR_UNIT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
