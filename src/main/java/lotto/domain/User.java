package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> userLottos;
    private GameMoney gameMoney;

    public User() {}

    public void payMoney(long money) {
        this.gameMoney = new GameMoney(money);
    }

    public void buyLotto() {
        userLottos = new ArrayList<>();
        int numberOfPurchases = gameMoney.numberOfPurchases();
        for (int lottoCount = 0; lottoCount < numberOfPurchases; lottoCount++) {
            Lotto newLotto = LottoGenerator.generatorLotto();
            userLottos.add(newLotto);
        }
    }

    public int getLottoCount() {
        return userLottos.size();
    }

    public long getGameMoney() {
        return gameMoney.getMoney();
    }

    public Lotto findLotto(int index) {
        return userLottos.get(index);
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
