package lotto.domain;

import static lotto.view.outputView.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class NumberGenerator {

    private static List<Lotto> lottoGroup = new ArrayList<>();

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
            lottoGroup.add(lotto);
        }
        System.out.println();
    }

    private static List<Integer> generateByRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.START.getValue(), LottoNumber.END.getValue(), LottoNumber.SIZE.getValue());
        Collections.sort(numbers);
        return numbers;
    }
}
