package lotto.domain;

import java.util.List;

public interface LottoProcessor {


    /**
     * @param winLotto
     * @param lotto
     * @return
     */
    int matchLottoNumber(Lotto winLotto, Lotto lotto);
}
