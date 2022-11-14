package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.UserValidator;
import lotto.validate.Validator;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int money;

    public void inputBuyLottoPrice() {
        String money = Console.readLine();
        Validator.isNumber(money);
        this.money = Integer.parseInt(money);
        UserValidator.isMoneyDividedLottoPrice(this.money);
        buyLotto();
    }

    private void buyLotto() {
        this.lottos = LottoGenerator.sellLottos(money);
    }
}
