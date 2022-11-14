package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public LottoGenerator() {
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoEnums.LOTTO_NUMBER_START.value(),
                                                LottoEnums.LOTTO_NUMBER_END.value(), LottoEnums.LOTTO_SIZE.value());
    }

    public Lotto getLotto() {
        return new Lotto(generateNumbers());
    }

    public Lotto convert2Lotto(String input) {
        List<Integer> lottos = LottoValidator.parseCommaString(input);
        if (lottos.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 개수는 6개여야 합니다.");
        return new Lotto(lottos);
    }
}
