package lotto.domain.lotto.lottocompany;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.lotto.Lotto;

public interface LottoCompany {

    List<Lotto> publishNLotto(int publishLottoCount);

    Map<Win, Integer> makeWinResult(List<Lotto> publishedNLotto, List<String> winningNumbers, int bonusNumber);

    int getTotalPrize();
}
