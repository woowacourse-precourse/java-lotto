package lotto.LottoShop;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoManager.Lotto;

import java.util.List;

public class Consumer {
    private final Clerk clerk;
    private List<Lotto> lotto_group;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void purchaseLotto() {
        String purchaseAmount = Console.readLine();

        this.lotto_group = clerk.sellLotto(purchaseAmount);
    }

    public void checkPrize(List<Integer> winning_numbers, int bonus_number) {


    }
}
