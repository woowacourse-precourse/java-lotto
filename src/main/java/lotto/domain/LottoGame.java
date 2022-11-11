package lotto.domain;

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
        int bonus = additionalNumber.getBonus(); // 보너스 입력 값

        BonusBallUsedLottery bonusBallUsedLottery = new BonusBallUsedLottery();
        List<Integer> bonusNumbers = bonusBallUsedLottery.getLocations(lists, number, bonus); // 보너스 위치

        for (int c : bonusNumbers) {
            System.out.println(c);
        }

        BonusBallCaseCheck bonusBallCaseCheck = new BonusBallCaseCheck();
        List<Integer> updateWinningNumber = bonusBallCaseCheck.updateWinningNumber(number, bonusNumbers);


    }
}