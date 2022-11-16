package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoInfo;
import java.util.List;
import java.util.stream.Collectors;

public class StoreService {
    public Lotto sellLotto(){
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(
                        LottoInfo.MIN.getValue(), LottoInfo.MAX.getValue(),
                        LottoInfo.LENGTH.getValue());
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(sorted);
    }

    public int numberOfSoldLotto(int money){
        return money / LottoInfo.PRICE.getValue();
    }
}
