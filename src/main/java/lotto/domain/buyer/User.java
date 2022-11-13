package lotto.domain.buyer;

import camp.nextstep.edu.missionutils.Console;

public class User implements Buyer {

    public int enterToBuyLottoForMoney() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
