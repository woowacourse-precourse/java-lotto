package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.HashMap;
import java.util.List;

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
            throw new IllegalArgumentException(ErrorMessage.Not_Digit.getMessage());
        }
    }

    private void priceRange(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.Purchase_Price.getMessage());
        } else if(money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.Purchase_Price.getMessage());
        }
    }

    public HashMap<Integer, List<Integer>> lottoPurchase() {
        LottoGenerator lottoGenerator = new LottoGenerator(money);
        return lottoGenerator.userLottoNumbers();
    }

    public int userMoney() {
        return money;
    }
}
