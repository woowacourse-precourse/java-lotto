package lotto.rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;

public class RankChecker {

    public static Map<Rank, Integer> checkRank(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> ranks = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = checkIndividualRank(lotto, winningLotto);
            ranks.merge(rank, 1, (k, v) -> ranks.get(rank) + 1);
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
