package lotto.domain.buyer;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class User implements Buyer {

    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int enterToBuyLottoForMoney() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    @Override
    public double calculateProfitRatio(int amount) {
        System.out.println(lottos.size());
        if (lottos.size() == 0) {
            return 0;
        }
        double profitRatio = ((double) amount * 100) / (lottos.size() * 1000);
        return (Math.round(profitRatio * 10) / 10.0);
    }
}
