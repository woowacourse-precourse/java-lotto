package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Maker {
    Generator generator;
    List<Integer> result;
    public Maker() {
        generator = new Generator();
        result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0));
    }

    public void make(Map<Lotto, Bonus> lotteries) {
        List<Integer> winNumber = generator.getWinNumber();

        for (Lotto lotto: lotteries.keySet()) {
            int bonusNumber = lotteries.get(lotto).getBonusNumber();
            int matchingCount = (int)lotto.getNumbers().stream().filter(i -> winNumber.contains(i)).count();

            if (rankingIsSecond(bonusNumber, matchingCount)) {
                increaseRankingCount(Ranking.second);
                continue;
            }
            Arrays.stream(Ranking.values()).filter(ranking -> ranking != Ranking.second)
                    .filter(ranking -> ranking.matchingCount() == matchingCount)
                            .forEach(ranking -> increaseRankingCount(ranking));
        }
    }

    private boolean rankingIsSecond(int bonusNumber, int matchingCount) {
        return Ranking.second.matchingCount() == matchingCount && generator.getWinNumber().contains(bonusNumber);
    }

    private void increaseRankingCount(Ranking ranking) {
        result.set(ranking.value(), result.get(ranking.value()) + 1);
    }

    List<Integer> getResult() {
        return result;
    }

}
