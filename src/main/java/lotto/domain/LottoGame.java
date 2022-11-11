package lotto.domain;

import lotto.Lotto;
import lotto.input.AdditionalNumber;
import lotto.input.LottoTickets;
import lotto.input.WinningNumber;

import java.util.List;

public class LottoGame {
    public void run() {
        LottoTickets lottoTickets = new LottoTickets();
        int paid = lottoTickets.getPaid();
        System.out.println(paid);

        RandomLotto randomLotto = new RandomLotto();
        List<List<Integer>> lists = randomLotto.randomGenerator(paid);
        for (List<Integer> b : lists) {
            System.out.println(b);
        }

        LottoComparison lottoComparison = new LottoComparison(new WinningNumber());
        List<Integer> number = lottoComparison.findNumber(lists);

        for (int a : number) {
            System.out.println(a);
        }


    }
}