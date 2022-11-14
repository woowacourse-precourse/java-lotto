package lotto;

import static lotto.outputView.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
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

    public static void generateLotto(int count) {
        for (int i = 0; i <count; i++){
            Lotto lotto = new Lotto(generateByRandom());
            printNumbers(lotto);
        }
    }

    private static List<Integer> generateByRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.START.getValue(), LottoNumber.END.getValue(), LottoNumber.SIZE.getValue());
        Collections.sort(numbers);
        return numbers;
    }
}
