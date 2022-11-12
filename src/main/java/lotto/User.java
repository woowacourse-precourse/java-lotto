package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    private int money;
    private List<Lotto> lottos;

    public User() {
        this.money = enterMoney();
    }

    private static int enterMoney() {
        System.out.println(Constants.CONSOLE_MONEY);

        int money = Integer.parseInt(Console.readLine());
        if (money % Constants.MONEY_TERMS != 0) {
            throw new IllegalArgumentException(Constants.LOTTO_MONEY_EXCEPTION);
        }

        return money;
    }

    public void buyLottoAll(Store store) {
        System.out.println();

        this.lottos = store.sell(this, this.money);
        int boughtLottosCount = this.lottos.size();

        System.out.println(boughtLottosCount + Constants.CONSOLE_BUY_RESULT);
    }

    protected int getMoney() {
        return money;
    }

    protected void setMoney(int money) {
        this.money = money;
    }

    public void printLotto() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
