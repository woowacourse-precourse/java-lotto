package lotto.domain.lotto;

import java.util.List;

public interface LottoGenerator {

    List<Lotto> generateByCount(int count);
}
