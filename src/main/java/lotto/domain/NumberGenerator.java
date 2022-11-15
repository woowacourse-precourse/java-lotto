package lotto.domain;

import static lotto.view.outputView.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class NumberGenerator {

    private final List<Lotto> lottoGroup = new ArrayList<>();
    public enum LottoNumber {
        START(1), END(45), SIZE(6);
        private final Integer value;

        LottoNumber(Integer value) {
            this.value =value;
        }

        public Integer getValue() {
            return value;
        }

    }

    public List<Lotto> generateLotto(int count) {
        for (int i = 0; i <count; i++){
            Lotto lotto = generateByRandom();
            lottoGroup.add(lotto);
        }
        return lottoGroup;
    }

    private Lotto  generateByRandom() {
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers = Randoms.pickUniqueNumbersInRange(LottoNumber.START.getValue(), LottoNumber.END.getValue(), LottoNumber.SIZE.getValue());
        randomNumbers = randomNumbers.stream().collect(Collectors.toList());
        return new Lotto(randomNumbers);
    }
}
