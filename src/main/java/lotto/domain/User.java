package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoGenerator;
import lotto.validate.UserValidator;
import lotto.validate.Validator;

import java.util.List;

import static lotto.util.Message.*;

public class User {

    private List<Lotto> lottos;
    private int money;

    public void start() {
        inputBuyLottoPrice();
        buyLotto();
        printLottos();
    }

    public void inputBuyLottoPrice() {
        System.out.println(INPUT_BUY_LOTTO_PRICE.getMessage());
        String money = Console.readLine();
        Validator.validNumber(money);
        this.money = Integer.parseInt(money);
        UserValidator.validMoneyDividedLottoPrice(this.money);
    }

    private void buyLotto() {
        this.lottos = LottoGenerator.sellLottos(money);
    }

    private void printLottos() {
        System.out.printf(BUY_LOTTO.getMessage(), lottos.size());
        lottos.forEach(System.out::println);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}
