package lotto;

import lotto.domain.RandomLotto;
import lotto.input.LottoTickets;
import lotto.input.WinningNumber;

import java.util.List;

public class LottoGame {
    public void run() {
        LottoTickets lottoTickets = new LottoTickets();
        int paid = lottoTickets.getPaid();

        RandomLotto randomLotto = new RandomLotto();
        List<List<Integer>> lists = randomLotto.randomGenerator(paid);

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.getAnswer();



        for (List<Integer> list : lists) {
            System.out.println(list);
        }



    }
}
