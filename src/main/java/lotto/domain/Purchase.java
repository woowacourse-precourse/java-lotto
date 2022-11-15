package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

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
            System.out.println(Not_Digit.getMessage());
            throw new NoSuchElementException();
        }
    }

    private void priceRange(int money) {
        if(money % 1000 != 0) {
            System.out.println(Purchase_Price.getMessage());
            throw new IllegalArgumentException();
        } else if(money <= 0) {
            System.out.println(Purchase_Price.getMessage());
            throw new IllegalArgumentException();
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
