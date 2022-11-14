package lotto;

import java.util.List;

public class User {

    private int money;
    private List<Lotto> lottos;

    public User(int money) {
        this.money = money;
    }

    public void buyLottoAll(Store store) {
        System.out.println();

        this.lottos = store.sell(this, this.money);
        int boughtLottosCount = this.lottos.size();

        System.out.printf(Constants.CONSOLE_BUY_RESULT_SUFFIX, boughtLottosCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLotto() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }


}
