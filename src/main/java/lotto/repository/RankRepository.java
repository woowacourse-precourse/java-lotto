package lotto.repository;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class RankRepository {

    static final Map<Score, Rank> ranks = new HashMap<>();

    static {
        insertRankData();
    }

    private static void insertRankData() {
        ranks.put(Score.of(6, false), FIRST);
        ranks.put(Score.of(6, true), FIRST);
        ranks.put(Score.of(5, true), SECOND);
        ranks.put(Score.of(5, false), THIRD);
        ranks.put(Score.of(4, false), FOURTH);
        ranks.put(Score.of(4, true), FOURTH);
        ranks.put(Score.of(3, false), FIFTH);
        ranks.put(Score.of(3, true), FIFTH);
    }

    public static Optional<Rank> getRank(Lotto playerLotto, WinningLotto winningLotto) {
        List<Integer> playerNumbers = playerLotto.getNumbers();
        int matchedCount = getMatchedCount(winningLotto, playerNumbers);
        boolean bonusMatch = isBonusMatch(winningLotto, playerNumbers);
        return Optional.ofNullable(ranks.get(Score.of(matchedCount, bonusMatch)));
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

    private static class Score {

        final int matchedCount;
        final boolean bonusMatch;

        private Score(int matchedCount, boolean bonusMatch) {
            this.matchedCount = matchedCount;
            this.bonusMatch = bonusMatch;
        }

        public static Score of(int matchedCount, boolean bonusMatch) {
            return new Score(matchedCount, bonusMatch);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Score)) {
                return false;
            }
            Score score = (Score) o;
            return matchedCount == score.matchedCount && bonusMatch == score.bonusMatch;
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchedCount, bonusMatch);
        }
    }
}
