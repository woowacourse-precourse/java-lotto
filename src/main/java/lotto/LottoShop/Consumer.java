package lotto.lottoShop;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Consumer {
    private final Clerk clerk;
    private List<Lotto> lotto_group;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void purchaseLotto() {
        String purchaseAmount = Console.readLine();

        lotto_group = clerk.sellLotto(purchaseAmount);

        printLottoGroup();
    }

    private void printLottoGroup() {

    }
}
