package lotto.domain;

import java.util.List;

public class Player {

    private List<Lotto> playerLottos;
    private int buyMoney;

    public Player(List<Lotto> playerLottos) {
        this.playerLottos = playerLottos;
    }

    public List<Integer> compareLotto(List<Lotto> playerLottos, Lotto lotto) {
        return null;
    }

    public void buyLotto(int buyMoney) {
        setBuyMoney(buyMoney);
        playerLottos = publishRandomNumbers(buyMoney);
    }

    private void setBuyMoney(int buyMoney) {
        this.buyMoney = buyMoney;
    }

    public List<Lotto> publishRandomNumbers(int buyMoney) {
        return null;
    }

    public void printPublishLotto() {
    }

    public void printRank() {
    }

    public void printYield() {
    }

}
