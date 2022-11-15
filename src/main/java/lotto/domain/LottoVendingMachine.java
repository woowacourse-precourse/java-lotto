package lotto.domain;

import java.util.List;

public interface LottoVendingMachine {
    List<Lotto> generateLottos(Integer money);
}
