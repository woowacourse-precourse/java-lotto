package lotto.domain.menu;

import java.util.List;
import lotto.Lotto;
import lotto.constants.SystemConsole;
import lotto.domain.BonusBallAndLotto;
import lotto.domain.TotalPrizeMoney;
import lotto.domain.WinningStatistics;
import lotto.domain.YieldCalculation;
import lotto.domain.subaction.BonusNumberCase;
import lotto.input.AdditionalNumber;

public class LottoGameManagement {
    private final AdditionalNumber additionalNumber;
    private final SystemConsole systemConsole;

    public LottoGameManagement(AdditionalNumber additionalNumber, SystemConsole systemConsole) {
        this.additionalNumber = additionalNumber;
        this.systemConsole = systemConsole;
    }

    public void bonusConfirmation(List<List<Integer>> randomLotto, Lotto lottoAnswer,
            List<Integer> sameNumberCount) {

        systemConsole.bonusNumber();
        List<Integer> bonusNumbers = getBonusNumbers(randomLotto, lottoAnswer, sameNumberCount);

        RankingWinner rankingWinner = new RankingWinner(new WinningStatistics(),
                new TotalPrizeMoney(), new YieldCalculation());

        rankingWinner.findAWinner(sameNumberCount, bonusNumbers);
    }

    private List<Integer> getBonusNumbers(List<List<Integer>> randomLotto, Lotto lottoAnswer,
            List<Integer> sameNumberCount) {

        int bonus = additionalNumber.getBonus(lottoAnswer);
        BonusBallAndLotto bonusBallAndLotto = new BonusBallAndLotto(new BonusNumberCase());

        return bonusBallAndLotto.getCorrectLocation(lottoAnswer, randomLotto, sameNumberCount,
                bonus);
    }
}
