package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int ONE_LOTTO_PRICE = 1000;
    public static List<Lotto> makeLotto(int price) {
        validate(price);
        List<Lotto> result = new ArrayList<>();
        for (int i=0; i<price/ONE_LOTTO_PRICE; i++) {
            result.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return result;
    }

    private static void validate(int price) {
        if (price % ONE_LOTTO_PRICE != 0 || price < 1000)
            throw new IllegalArgumentException("로또는 1000원 단위로 구매할 수 있습니다.");
    }
}
