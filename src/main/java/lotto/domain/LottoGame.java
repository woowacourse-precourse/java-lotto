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
        List<List<Integer>> lists = randomLotto.randomGenerator(paid); // 랜덤 리스트
        for (List<Integer> b : lists) {
            System.out.println(b);
        }

        LottoComparison lottoComparison = new LottoComparison(new WinningNumber());
        List<Integer> number = lottoComparison.findNumber(lists); // 결과 리스트

        for (int a : number) {
            System.out.println(a);
        }

        AdditionalNumber additionalNumber = new AdditionalNumber();
        int bonus = additionalNumber.getBonus();

        BonusLottoBall bonusLottoBall = new BonusLottoBall();
        List<Integer> bonusNumbers = bonusLottoBall.findNumber(lists, number, bonus);

        for (int c : bonusNumbers) {
            System.out.println(c);
        }

    }
}