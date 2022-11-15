package lotto.rank;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;

public class RankChecker {

    public static List<Rank> checkRank(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(checkIndividualRank(lotto, winningLotto));
        }
        return ranks;
    }

    private static Rank checkIndividualRank(Lotto lotto, WinningLotto winningLotto) {
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        List<LottoNumber> winningNumbers = winningLotto.getNumbers();
        LottoNumber bonusNumber = winningLotto.getBonusNumber();
        return Rank.getRank(getWinningBallMatchCount(lottoNumbers, winningNumbers),
                verifyBonusBallMatch(lottoNumbers, bonusNumber));
    }

    private static int getWinningBallMatchCount(List<LottoNumber> lottoNumbers,
            List<LottoNumber> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private static boolean verifyBonusBallMatch(List<LottoNumber> lottoNumbers,
            LottoNumber bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }
}
