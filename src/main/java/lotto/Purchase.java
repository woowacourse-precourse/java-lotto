package lotto;

import lotto.message.ErrorMessage;

public class Purchase {
    private final int money;

    public Purchase(String money) {
        validate(money);
        priceRange(Integer.parseInt(money));
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Not_Digit));
        }
    }

    private void priceRange(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Purchase_Price));
        } else if(money <= 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Purchase_Price));
        }
    }

    public int price() {
        return money;
    }
}
