package user;

import lotto.Lotto;
import ui.View;

import java.util.List;

public class User {

    private final int BASE_MONEY = 1000;
    private List<Lotto> lottos;
    private Money seedMoney;
    private Money prizeMoney;

    public User() {
        seedMoney = new Money();
        prizeMoney = new Money(0);
    }

    public int getLottoMount() {
        return seedMoney.getMoney() / BASE_MONEY;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setPrizeMoney(Money prize) {
        prizeMoney = prize;
    }

    public String getRatio() {
        double prize = (double) prizeMoney.getMoney();
        double seed = (double) seedMoney.getMoney();
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
