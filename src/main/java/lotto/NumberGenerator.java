package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {

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
    public static List<Integer> generateByRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.START.getValue(), LottoNumber.END.getValue(), LottoNumber.SIZE.getValue());
        return numbers;
    }
}
