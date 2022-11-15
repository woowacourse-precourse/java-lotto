package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoStatistic;

public interface LottoService {

    List<Lotto> createLottos(int size);

    LottoStatistic makeStatistic(List<Lotto> lottos, long purchaseAmount,
        List<Integer> winningNumbers, int bonusNumber);
}
