package lotto.domain;

import org.mockito.internal.matchers.Not;

import java.util.HashMap;
import java.util.List;

import static lotto.message.ErrorMessage.*;

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
            throw new IllegalArgumentException(Not_Digit.getMessage());
        }
    }

    private void priceRange(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(Purchase_Price.getMessage());
        } else if(money <= 0) {
            throw new IllegalArgumentException(Purchase_Price.getMessage());
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
