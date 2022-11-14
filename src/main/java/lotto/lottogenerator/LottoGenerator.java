package lotto.lottogenerator;

import java.util.List;
import lotto.domain.PaidLotto;

public interface LottoGenerator {

    List<PaidLotto> generateLottoList(Integer lottoMountPerPrice);
}
