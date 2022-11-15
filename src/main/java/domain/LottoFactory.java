package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_INVALID_ARGUMENT = "[ERROR] Invalid Argument";

    public static Lottos makeLottos(Integer price) {
        checkVaildity(price);

        List<Lotto> lottos = new ArrayList<>();
        for (int time = 0; time < price / LOTTO_PRICE; time++) {
            List<Integer> rawNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(rawNumbers));
        }

        return new Lottos(lottos);
    }

    private static void checkVaildity(Integer price) {
        if (price % LOTTO_PRICE != 0 || price == 0) {
            throw new IllegalArgumentException(ERROR_INVALID_ARGUMENT);
        }
    }
}
