package lotto.domain;

import java.util.ArrayList;
import lotto.Lotto;
import lotto.constants.Rank;
import lotto.input.AdditionalNumber;
import lotto.input.LottoTickets;
import lotto.input.WinningNumber;

import java.util.List;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final RandomLottoGenerator randomLottoGenerator;
    private final WinningNumber winningNumber;

    public LottoGame(LottoTickets lottoTickets, RandomLottoGenerator randomLottoGenerator, WinningNumber winningNumber) {
        this.lottoTickets = lottoTickets;
        this.randomLottoGenerator = randomLottoGenerator;
        this.winningNumber = winningNumber;
    }

    public void setUp() {
        int lottos = lottoTickets.getPaid();
        List<List<Integer>> lists = randomLottoGenerator.createTicket(lottos);
        Lotto lottoAnswer = winningNumber.getCorrect();




        LottoComparison lottoComparison = new LottoComparison();
        List<Integer> number = lottoComparison.findNumber(lottoAnswer, lists); // 결과 리스트

        System.out.println();
        AdditionalNumber additionalNumber = new AdditionalNumber();
        int bonus = additionalNumber.getBonus(); // 보너스 입력 값

        BonusBallUsedLottery bonusBallUsedLottery = new BonusBallUsedLottery();
        List<Integer> bonusNumbers = bonusBallUsedLottery.getLocations(lottoAnswer, lists, number,
                bonus); // 보너스 위치

        WinningStatistics winningStatistics = new WinningStatistics();
        List<Integer> countCheck = winningStatistics.countCheck(number, bonusNumbers);


        for (int i = 0; i < countCheck.size(); i++) {
            if (i == 0) {
                System.out.println(
                        Rank.FIFTH.getMatch() + "개 일치 (5,000원) - " + countCheck.get(i) + "개");
            }

            if (i == 1) {
                System.out.println(
                        Rank.FOURTH.getMatch() + "개 일치 (50,000원) - " + countCheck.get(i) + "개");
            }

            if (i == 2) {
                System.out.println(
                        Rank.THIRD.getMatch() + "개 일치 (1,500,000원) - " + countCheck.get(i) + "개");
            }

            if (i == 3) {
                System.out.println(
                        Rank.SECOND.getMatch() + "개 일치, 보너스 볼 일치 (30,000,000원) - " + countCheck.get(i) + "개");
            }

            if (i == 4) {
                System.out.println(
                        Rank.FIRST.getMatch() + "개 일치 (2,000,000,000원) - " + countCheck.get(i) + "개");
            }
        }

        TotalPrizeMoney totalPrizeMoney = new TotalPrizeMoney();
        int calculation = totalPrizeMoney.calculation(number, countCheck);

        YieldCalculation yieldCalculation = new YieldCalculation();

        double revenue = yieldCalculation.revenue(calculation);

    }


}