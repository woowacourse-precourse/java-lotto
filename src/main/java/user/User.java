package user;

import lotto.Lotto;
import ui.View;

import java.util.List;

public class User {

    private final int BASE_MONEY = 1000;
    private List<Lotto> lottos;
    private int seedMoney;
    private int prizeMoney;

    public User() {
        seedMoney = NumberComponent.makeMoney();
        prizeMoney = 0;
    }

    public int getLottoMount() {
        return seedMoney / BASE_MONEY;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setPrizeMoney(int prize) {
        NumberComponent.checkMoney(prize);
        prizeMoney = prize;
    }

    public String getRatio() {
        double prize = (double) prizeMoney;
        double seed = (double) seedMoney;
        return String.format("%.1f", prize / seed * 100);
    }

    public void printPurchaseResult() {
        View.printPurchaseMount(this);
        View.printLottoList(this);
    }
    public void printRatio(){
        View.printTotalPrize(this);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
