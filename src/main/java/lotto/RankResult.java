package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.InputView.inputBonusNumber;
import static lotto.InputView.inputWinLotto;

public class RankResult {

    private RankCalculator rankCalculator;
    private Map<Rank, Integer> rankMap;

    public RankResult() {
        rankCalculator = new RankCalculator();
        rankMap = new EnumMap<>(Rank.class);
    }

    public void initEnumMap() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankMap.put(rank, 0));
    }

    public void addRankMapCount(List<List<Integer>> randomLottos) {
        List<Integer> winLotto = inputWinLotto();
        int bonus = inputBonusNumber();

        for (List<Integer> randomLotto : randomLottos) {
            Rank rank = rankCalculator.calculate(winLotto, randomLotto, bonus);
            int previousCount = rankMap.getOrDefault(rank, 0);
            rankMap.put(rank, previousCount + 1);
        }
    }
}
