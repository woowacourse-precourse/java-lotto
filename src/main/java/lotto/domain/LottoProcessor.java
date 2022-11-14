package lotto.domain;

import java.util.List;

public interface LottoProcessor {


    /**
     * @pa호am winLotto
     * @param lotto
     * @return
     */
    int matchLottoNumber(Lotto winLotto, Lotto lotto);

    Boolean matchBonusNumber(Integer bonusNumber, Lotto lotto);
}
