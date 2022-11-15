package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.util.SystemMessage;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private List<Lotto> lottos = new ArrayList<>();
    private Money money;

    public BuyLotto() {
        this.money = inputMoney();
        for (int i = 0; i < availablePurchasesNumber(money.getMoney()); i++) {
            lottos.add(i, new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Money getMoney() {
        return money;
    }

    private int availablePurchasesNumber(int money) {
        return money / 1000;
    }

    private Money inputMoney() {
        System.out.println(SystemMessage.MONEY_INPUT.getContent());
        return new Money(Console.readLine());
    }

    public void showLottosNumber() {
        System.out.printf(SystemMessage.PURCHASES_RESULT.getContent(), lottos.size());
    }
    public void showLottosList() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumber());
        }
    }
}
