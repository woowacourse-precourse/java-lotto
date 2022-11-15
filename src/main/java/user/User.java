package user;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int BASE_MONEY = 1000;
    private final int ONE_HUNDRED_PERCENT = 100;
    private final boolean HAVE = true;
    private List<Lotto> lottos;
    private long seedMoney;
    private long prizeMoney;

    public User() {
        lottos = new ArrayList<>();
        seedMoney = NumberValidator.makeMoney();
        prizeMoney = 0;
    }

    public int getLottoMount() {
        return (int)seedMoney / BASE_MONEY;
    }

    public void addLottos(Lotto lotto) {
        if(this.hasLotto(lotto) != HAVE){
            lottos.add(lotto);
        }
    }

    public void setPrizeMoney(long prize) {
        prizeMoney = prize;
    }

    public String getRatio() {
        double prize = (double) prizeMoney;
        double seed = (double) seedMoney;
        return String.format("%.1f", prize / seed * ONE_HUNDRED_PERCENT);
    }

    public boolean hasLotto(Lotto lotto){
//        return lottos.contains(lotto);
        return false;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
