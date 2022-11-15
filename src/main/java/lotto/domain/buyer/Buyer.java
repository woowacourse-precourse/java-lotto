package lotto.domain.buyer;

import java.util.List;
import lotto.domain.lotto.Lotto;

public interface Buyer {

    double calculateProfitRatio(int amount);

    List<Lotto> getLottos();
}
