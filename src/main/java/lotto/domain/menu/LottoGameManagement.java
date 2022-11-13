package lotto.domain.menu;

import java.util.List;
import lotto.Lotto;
import lotto.domain.BonusBallAndLotto;
import lotto.domain.TotalPrizeMoney;
import lotto.domain.WinningStatistics;
import lotto.domain.YieldCalculation;
import lotto.domain.subaction.BonusNumberCase;
import lotto.input.AdditionalNumber;

public class LottoGameManagement {
    private final AdditionalNumber additionalNumber;

    public LottoGameManagement(AdditionalNumber additionalNumber) {
        this.additionalNumber = additionalNumber;
    }

    public List<Integer> bonusConfirmation(List<List<Integer>> randomLotto, Lotto lottoAnswer, List<Integer> sameNumberCount) {
        int bonus = additionalNumber.getBonus();

        BonusBallAndLotto bonusBallAndLotto = new BonusBallAndLotto(new BonusNumberCase());
        List<Integer> bonusNumbers = bonusBallAndLotto.getCorrectLocation(lottoAnswer, randomLotto, sameNumberCount, bonus);

        System.out.println("보너스사용자리");
        for (int tt : bonusNumbers) {
            System.out.println(tt);
        }

        RankingWinner rankingWinner = new RankingWinner(new WinningStatistics(), new TotalPrizeMoney(), new YieldCalculation());
        rankingWinner.findAWinner(sameNumberCount, bonusNumbers);

        return null;
    }
}
