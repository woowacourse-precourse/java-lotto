package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Consumer {
    private List<Lotto> lotto_group;

    public Consumer() {
    }

    public void purchaseLotto() {
        String purchaseAmount = Console.readLine();

        lotto_group = Clerk.sellLotto(purchaseAmount);

        printLottoGroup();
    }

    private void printLottoGroup() {

    }
}
