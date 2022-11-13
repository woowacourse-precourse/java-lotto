package lotto.game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.LottoWinningRanking;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningResult;
import lotto.domain.WinningLotto;

public class LottoWinningChecker {

    private final WinningLotto winningLotto;

    public LottoWinningChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoWinningResult checkWinning(List<Lotto> lottos) {
        Map<LottoWinningRanking, Integer> numberOfWinningEachRank = Arrays.stream(LottoWinningRanking.values())
                .collect(Collectors.toMap(ranking -> ranking, init -> 0));

        for (Lotto lotto : lottos) {
            LottoWinningRanking winningResult = checkWinning(lotto);
            numberOfWinningEachRank.compute(winningResult, (rank, numberOfWinning) -> numberOfWinning + 1);
        }
        return new LottoWinningResult(numberOfWinningEachRank);
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
