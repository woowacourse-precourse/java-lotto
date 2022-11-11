package lotto.domain.model;

import static lotto.utils.Advice.PurchaseValidator.checkConsistNumber;
import static lotto.utils.Advice.PurchaseValidator.checkReminder;

public class Pay {

    private final Long pay;

    public Pay(String pay) {
        validate(pay);
        this.pay = Long.valueOf(pay);
    }

    private void validate(String pay) {
        checkConsistNumber(pay);
        checkReminder(pay);
    }

    public Long getPay() {
        return pay;
    }


}
