package lotto.game;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoWinningRanking;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoWinningChecker {

    private final WinningLotto winningLotto;

    public LottoWinningChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<LottoWinningRanking> checkWinning(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::checkWinning)
                .collect(Collectors.toList());
    }

    public LottoWinningRanking checkWinning(Lotto lotto) {
        int numberOfMatchesWinningNumber = countMatchesOfWinningNumber(lotto);
        boolean matchesBonusNumber = matchesBonusNumber(lotto);
        return LottoWinningRanking.findByMatches(numberOfMatchesWinningNumber, matchesBonusNumber);
    }

    private int countMatchesOfWinningNumber(Lotto lotto) {
        return (int) winningLotto.getWinningNumbers().stream()
                .filter(lotto::isContains)
                .count();
    }

    private boolean matchesBonusNumber(Lotto lotto) {
        return lotto.isContains(winningLotto.getBonusNumber());
    }
}
