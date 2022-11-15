package lotto.infrastructure;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoProvider {

    List<Lotto> createLottos(int lottoCount);

    Lotto createLotto();

}
