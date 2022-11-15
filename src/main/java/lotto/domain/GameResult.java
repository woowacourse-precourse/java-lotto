package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final Map<Ranking, Integer> gameResult = new EnumMap<>(Ranking.class);

    public GameResult(List<Ranking> rankings) {
        matchRanking(rankings);
    }

    private void matchRanking(List<Ranking> rankings) {
        List<Ranking> lottoRankings = Ranking.generateRankings();

        for (Ranking ranking : rankings) {
            gameResult.put(ranking, gameResult.getOrDefault(ranking, 0) + 1);
        }

        for (Ranking ranking : lottoRankings) {
            if (!gameResult.containsKey(ranking)) {
                gameResult.put(ranking, 0);
            }
        }
    }

    public Map<Ranking, Integer> getGameResult() {
        return gameResult;
    }
}
