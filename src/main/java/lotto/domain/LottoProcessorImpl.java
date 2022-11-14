package lotto.domain;

import java.util.List;

public class LottoProcessorImpl implements LottoProcessor{

    //몇개가 일치하는지 알려주는 로직
    @Override
    public int matchLottoNumber(Lotto winLotto, Lotto lotto) {
        int equalCount = 0;
        for(Integer number: lotto.getNumbers()) {
            if (winLotto.getNumbers().contains(number)) {
                equalCount++;
            }
        }
        return equalCount;
    }

    @Override
    public Boolean matchBonusNumber(Integer bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
