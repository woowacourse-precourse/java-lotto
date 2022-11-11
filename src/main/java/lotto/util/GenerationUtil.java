package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.enums.ConstVariable;

import java.util.*;

public class GenerationUtil {

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(ConstVariable.MIN_NUMBER.getValue(),
                ConstVariable.MAX_NUMBER.getValue(),
                ConstVariable.LOTTO_COUNT.getValue());
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            System.out.println(lotto.printNumbers());
            generatedLottos.add(lotto);
        }
        return generatedLottos;
    }
}
