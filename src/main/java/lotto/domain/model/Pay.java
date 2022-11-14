package lotto.domain.model;

import static lotto.utils.Advice.PurchaseValidator.MINIMUM_ORDER;
import static lotto.utils.Advice.PurchaseValidator.checkConsistNumber;
import static lotto.utils.Advice.PurchaseValidator.checkReminder;

public class Pay {

    private final Long pay;

    public Pay(final String pay) {
        validate(pay);
        this.pay = Long.valueOf(pay);
    }

    private void validate(final String pay) {
        checkConsistNumber(pay);
        checkReminder(pay);
    }

    public int calculateQuantity() {
        return (int) (this.pay / MINIMUM_ORDER);
    }

    public Double calculateYield(long reward) {
        return (reward / (double)this.pay) * 100;
    }
}
