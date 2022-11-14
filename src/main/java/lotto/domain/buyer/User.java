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

}
