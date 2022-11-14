package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final int MIN_BUY_UNIT = 1_000;
    private static final String MESSAGE_COUNT_BUY = "%d개를 구매했습니다.";

    private List<Lotto> lottos;
    private int money;
    private int countLottos;

    public Buyer(int inputMoney) {
        Money money = new Money(inputMoney);
        this.money = money.getMoney();
        this.countLottos = inputMoney / MIN_BUY_UNIT;
        buyLottos();
    }

    private void buyLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countLottos; i++) {
            lottos.add(Lotto.make());
        }
        this.lottos = lottos;
    }

    public void printBuyLottos() {
        System.out.println(String.format(MESSAGE_COUNT_BUY, countLottos));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}
