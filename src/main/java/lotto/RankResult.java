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

    public RankResult(){
        rankCalculator = new RankCalculator();
        rankMap = new EnumMap<>(Rank.class);
    }

    public void initEnumMap() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankMap.put(rank, 0));
    }
}
