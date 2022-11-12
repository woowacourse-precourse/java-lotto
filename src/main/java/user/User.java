package user;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import ui.View;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private Money seedMoney;
    private Money prizeMoney;

    public User() {
        seedMoney = new Money();
        prizeMoney = new Money(0);
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
        return String.format("%.1f", prize / seed);
    }

    public Money getSeedMoney() {
        return seedMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
