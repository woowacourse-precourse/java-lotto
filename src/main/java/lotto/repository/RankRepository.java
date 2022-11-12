package lotto.repository;

import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class RankRepository {

    public static Optional<Rank> getRank(Lotto playerLotto, WinningLotto winningLotto) {
        List<Integer> playerNumbers = playerLotto.getNumbers();
        int matchedCount = getMatchedCount(winningLotto, playerNumbers);
        boolean bonusMatch = isBonusMatch(winningLotto, playerNumbers);
        return Optional.ofNullable(Rank.getRank(matchedCount, bonusMatch));
    }

    private static int getMatchedCount(WinningLotto winningLotto, List<Integer> playerNumbers) {
        List<Integer> winningLottoNumbers = winningLotto.getLotto().getNumbers();
        return playerNumbers.stream()
                .reduce(0, (matchedCount, playerNumber) -> {
                    if (winningLottoNumbers.contains(playerNumber)) {
                        return matchedCount + 1;
                    }
                    return matchedCount;
                });
    }

    private static boolean isBonusMatch(WinningLotto winningLotto, List<Integer> playerNumbers) {
        return playerNumbers.contains(winningLotto.getBonusNumber());
    }
}
