package lotto.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.WinningNumber;
import lotto.generator.NumberGenerator;
import lotto.result.RewardEnum;
import lotto.ui.Input.ParameterInput;
import lotto.ui.text.ErrorText;
import lotto.ui.text.InputText;
import lotto.ui.text.DynamicText;

public class LottoManager {
    private final NumberGenerator generator;
    private final ParameterInput input;

    public LottoManager(NumberGenerator generator, ParameterInput input) {
        this.generator = generator;
        this.input = input;
    }

    public void tryLotto() {
        int lottoQuantity = input.readQuantityFromMoney();
        System.out.println();

        List<Lotto> lottoList = buyLotto(lottoQuantity);
        System.out.println(DynamicText.totalQuantity(lottoQuantity));
        System.out.println(DynamicText.totalLotto(lottoList));
        System.out.println();

        WinningNumber winningNumber = input.readWinningNumber();
        System.out.println();

        Map<RewardEnum, Integer> statistics = makeStatistics(lottoList, winningNumber);
        System.out.println(DynamicText.statistics(statistics));
    }

    private List<Lotto> buyLotto(int quantity) {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() < quantity) {
            lottoList.add(new Lotto(generator.generate(1, 45, 6)));
        }
        return lottoList;
    }

    public Map<RewardEnum, Integer> makeStatistics(List<Lotto> lottoList, WinningNumber winningNumber) {
        Map<RewardEnum, Integer> statistics = new HashMap<>();
        for (RewardEnum reward : RewardEnum.values()) {
            statistics.put(reward, 0);
        }

        for (Lotto lotto : lottoList) {
            RewardEnum matchResult = lotto.match(winningNumber);
            statistics.put(matchResult, statistics.get(matchResult) + 1);
        }

        return statistics;
    }
}
