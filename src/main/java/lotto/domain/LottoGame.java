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

        WinningNumber winningNumber = new WinningNumber();
        Lotto lottoAnswer = winningNumber.getAnswer(); // 당첨되는 숫자들

        LottoComparison lottoComparison = new LottoComparison();
        List<Integer> number = lottoComparison.findNumber(lottoAnswer, lists); // 결과 리스트

        for (int a : number) {
            System.out.println(a);
        }

        AdditionalNumber additionalNumber = new AdditionalNumber();
        int bonus = additionalNumber.getBonus(); // 보너스 입력 값

        BonusBallUsedLottery bonusBallUsedLottery = new BonusBallUsedLottery();
        List<Integer> bonusNumbers = bonusBallUsedLottery.getLocations(lottoAnswer, lists, number, bonus); // 보너스 위치

        for (int c : bonusNumbers) {
            System.out.println(c);
        }

        System.out.println("마지막--------");

        WinningStatistics winningStatistics = new WinningStatistics();
        List<Integer> countCheck = winningStatistics.countCheck(number, bonusNumbers);

        for (int t : countCheck) {
            System.out.println(t);
        }

        TotalPrizeMoney totalPrizeMoney = new TotalPrizeMoney();
        int calculation = totalPrizeMoney.calculation(number, countCheck);
        System.out.println("총값은:" + calculation);

        YieldCalculation yieldCalculation = new YieldCalculation();

        double revenue = yieldCalculation.revenue(calculation);
        //double revenue = yieldCalculation.revenue(calculation, paid);

        System.out.println("확인해보자:" + revenue);

        System.out.println(String.format("%.1f", revenue));


    }
}