package lotto.Model;

import static lotto.Validator.Min_money;
import static lotto.Validator.checkConsistNumber;
import static lotto.Validator.checkReminder;

public class Price {

    private final Long price;

    public Price(final String price) {
        validate(price);
        this.price = Long.valueOf(price);
    }

    private void validate(final String price) {
        checkConsistNumber(price);
        checkReminder(price);
    }

    public int calculateQuantity() {
        return (int) (this.price / Min_money);
    }

    public Double calearning(long reward) {
        return (reward / (double)this.price) * 100;
    }
}
