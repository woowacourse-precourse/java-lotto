package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoInfo;
import java.util.List;

public class StoreService {
    public Lotto sellLotto(){
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(
                        LottoInfo.MIN.getValue(), LottoInfo.MAX.getValue(),
                        LottoInfo.LENGTH.getValue());
        return new Lotto(numbers);
    }
}
