package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validator;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int money;

    public void inputBuyLottoPrice() {
        String money = Console.readLine();
        Validator.isNumber(money);
        // 1000원으로 나누어 떨어지지 않을 때 예외처리
        this.money = Integer.parseInt(money);
        buyLotto();
    }

    private void buyLotto() {
        this.lottos = LottoGenerator.sellLottos(money);
    }
}
