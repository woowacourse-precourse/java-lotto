package lotto.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinningNumber;
import lotto.generator.NumberGenerator;
import lotto.result.RewardEnum;
import lotto.ui.Input.ParameterInput;

public class LottoManager {
    private final NumberGenerator generator;
    private final ParameterInput input;

    public LottoManager(NumberGenerator generator, ParameterInput input) {
        this.generator = generator;
        this.input = input;
    }

    public int getQuantity() {
        return input.readQuantityFromMoney();
    }

    public WinningNumber getWinningNumber() {
        return input.readWinningNumber();
    }

    public List<Lotto> buyLotto(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() < quantity) {
            lottoList.add(new Lotto(generator.generate(1, 45, 6)));
        }
        return lottoList;
    }

    public Map<RewardEnum, Integer> makeStatistics(List<Lotto> lottoList, WinningNumber winningNumber) {
        Map<RewardEnum, Integer> statistics = initStatistics();
        for (Lotto lotto : lottoList) {
            RewardEnum matchResult = lotto.match(winningNumber);
            statistics.put(matchResult, statistics.get(matchResult) + 1);
        }
        return statistics;
    }

    private Map<RewardEnum, Integer> initStatistics() {
        Map<RewardEnum, Integer> statistics = new HashMap<>();
        for (RewardEnum reward : RewardEnum.values()) {
            statistics.put(reward, 0);
        }
        return statistics;
    }
}
