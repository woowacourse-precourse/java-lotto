package lotto.domain.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningLotto;
import lotto.domain.model.WinningStatistics;
import lotto.domain.model.enums.Reward;
import lotto.domain.model.request.MoneyRequest;

public class LottoService {

    // 로또를 생성하고 로또들을 반환
    public Lottos getGeneratedLottoList(MoneyRequest moneyRequest) {
        LottoGenerator generator = new LottoGenerator(moneyRequest);
        return generator.getLottos();
    }

    public WinningStatistics getWinningStatistics(WinningLotto winningLotto, Lottos lottos) {
        Map<Reward, Integer> resultMap = new HashMap<>();
        for (Reward reward : Reward.values()) {
            resultMap.put(reward, 0);
        }

        for (int index = 0; index < lottos.size(); index++) {
            Reward reward = Reward.getRank(winningLotto, lottos.getLotto(index));
            int value = resultMap.get(reward);
            resultMap.replace(reward, value + 1);
        }
        return new WinningStatistics(resultMap);
    }

}
