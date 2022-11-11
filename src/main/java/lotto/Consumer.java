package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Consumer {
    private List<Lotto> lottoList;

    public Consumer() {
    }

    public void purchaseLotto() {
        String purchaseAmount = Console.readLine();
        lottoList = Clerk.sellLotto(purchaseAmount);
    }

}
