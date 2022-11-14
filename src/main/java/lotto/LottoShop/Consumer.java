package lotto.LottoShop;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoManager.Lotto;
import lotto.LottoManager.LottoDrawingMachine;

import java.util.List;
import java.util.stream.Collectors;

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

    public void checkPrize() {
//        List<Integer> prizes =
//                lotto_group.stream()
//                        .map(LottoDrawingMachine::calculatePrize)
//                        .collect(Collectors.toList());

    }
}
