package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.ConstValue.PURCHASED_AMOUNT_UNIT;
import static lotto.constant.Message.*;

public class PurchasedAmount {
    private int price;

    public PurchasedAmount(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return this.price / PURCHASED_AMOUNT_UNIT;
    }

}
