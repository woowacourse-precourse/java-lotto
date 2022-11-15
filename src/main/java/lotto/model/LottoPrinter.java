package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPrinter {
    public static List<Lotto> printLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(printLotto());
        }
        return lottos;
    }

    private static Lotto printLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constants.MINIMUM_LOTTO_NUMBER, Constants.MAXIMUM_LOTTO_NUMBER, Constants.THE_NUMBER_OF_LOTTO_NUMBERS));
    }
}
