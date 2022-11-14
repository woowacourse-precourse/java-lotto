package lotto;

import java.util.List;

public class Run {
    Run() {
        BuyingLotto buyingLotto = new BuyingLotto();
        WinningNumbers winningNumbers = new WinningNumbers();

        List<List<Integer>> myLotto = buyingLotto.lottos;
        List<Integer> winningLotto = winningNumbers.lotto;
        int winningBonus = winningNumbers.bonus;

        new Result(myLotto, winningLotto, winningBonus);
    }
}
