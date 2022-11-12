package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.LottoInfo;

public class LottoFactory {
    public static Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoInfo.START_NUMBER.getNumber(),
                LottoInfo.END_NUMBER.getNumber(),
                LottoInfo.LENGTH.getNumber()
        );

        return new Lotto(randomNumbers);
    }
}
