package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Lotto> playerLottos;
    private int buyMoney;

    public List<Integer> compareLotto(Lotto lotto) {
        return null;
    }

    public List<Lotto> buyLotto(int buyMoney) {
        setBuyMoney(buyMoney);
        playerLottos = publishRandomNumbers();
        return playerLottos;
    }

    private void setBuyMoney(int buyMoney) {
        this.buyMoney = buyMoney;
    }

    private List<Lotto> publishRandomNumbers() {
        List<Lotto> playerLottos = new ArrayList<>();

        while (buyMoney >= 1000) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(uniqueNumbers);
            playerLottos.add(lotto);
            buyMoney -= 1000;
        }

        return playerLottos;
    }

    public void printPublishLotto() {
    }

    public void printRank() {
    }

    public void printYield() {
    }

}
