package lotto;

import lotto.domain.Cashier;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        User user = new User();

        int userValue = user.payPrice();
        int lottoAmount = cashier.sellLotto(userValue);

    }
}
