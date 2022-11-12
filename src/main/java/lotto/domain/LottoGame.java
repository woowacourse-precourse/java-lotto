package lotto.domain;

import jdk.dynalink.linker.ConversionComparator.Comparison;
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
        int lottos = lottoTickets.getPaid(); // 티켓 받기
        List<List<Integer>> randomLotto = randomLottoGenerator.createTicket(lottos); // 랜덤 받기
        Lotto lottoAnswer = winningNumber.getCorrect(); // 정답 받기

        LottoAndWinningNumber lottoAndWinningNumber = new LottoAndWinningNumber();
        List<Integer> sameNumberCount = lottoAndWinningNumber.comparison(randomLotto, lottoAnswer); // 결과 받기





        AdditionalNumber additionalNumber = new AdditionalNumber();
        int bonus = additionalNumber.getBonus(); // 보너스 입력 값

        BonusBallUsedLottery bonusBallUsedLottery = new BonusBallUsedLottery();
        List<Integer> bonusNumbers = bonusBallUsedLottery.getLocations(lottoAnswer, randomLotto, sameNumberCount,
                bonus); // 보너스 위치

        WinningStatistics winningStatistics = new WinningStatistics();
        List<Integer> countCheck = winningStatistics.countCheck(sameNumberCount, bonusNumbers);


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
        int calculation = totalPrizeMoney.calculation(sameNumberCount, countCheck);

        YieldCalculation yieldCalculation = new YieldCalculation();

        double revenue = yieldCalculation.revenue(calculation);

    }


}