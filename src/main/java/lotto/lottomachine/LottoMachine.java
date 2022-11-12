package lotto.lottomachine;

import lotto.user.User;
import lotto.user.validation.UserMoneyValidation;

public class LottoMachine {

    private static final int EXCEPTION_NUMBER = -1;
    private static final int INIT_MONEY = 0;
    private int lottoPrice;

    public LottoMachine() {
        lottoPrice = INIT_MONEY;
    }

    public void start() {
        buyLotto();
    }

    public void buyLotto() {
        String userLottoPrice = User.buyLotto();
        try {
            UserMoneyValidation.validate(userLottoPrice);
            lottoPrice = Integer.parseInt(userLottoPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoPrice = EXCEPTION_NUMBER;
        }
    }
}
