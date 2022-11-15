package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoGenerator;
import lotto.util.Message;
import lotto.validate.UserValidator;
import lotto.validate.Validator;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int money;

    public void start() {
        inputBuyLottoPrice();
        buyLotto();
        printLottos();
    }

    public void inputBuyLottoPrice() {
        System.out.println(Message.INPUT_BUY_LOTTO_PRICE);
        String money = Console.readLine();
        Validator.validNumber(money);
        this.money = Integer.parseInt(money);
        UserValidator.validMoneyDividedLottoPrice(this.money);
    }

    private void buyLotto() {
        this.lottos = LottoGenerator.sellLottos(money);
    }

    private void printLottos() {
        System.out.printf(Message.BUY_LOTTO, lottos.size());
        lottos.forEach(System.out::println);
    }
}
