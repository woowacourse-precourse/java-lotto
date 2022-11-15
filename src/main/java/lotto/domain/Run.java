package lotto.domain;

import lotto.domain.buy.BuyingLotto;
import lotto.domain.getwin.WinningNumbers;
import lotto.domain.result.Result;

import java.util.List;

public class Run {
    public Run() {
        BuyingLotto buyingLotto = new BuyingLotto();
        WinningNumbers winningNumbers = new WinningNumbers();

        List<List<Integer>> myLotto = buyingLotto.lottos;
        List<Integer> winningLotto = winningNumbers.lotto;
        int winningBonus = winningNumbers.bonus;

        new Result(myLotto, winningLotto, winningBonus);
    }
}
