package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
    public static final int ONE_LOTTO_PRICE = 1000;
    public static List<Lotto> makeLotto(int price) throws Exception{
        validate(price);
        return getLottos(getNumOfLotto(price));
    }

    private static void validate(int price) throws Exception {
        if (price % ONE_LOTTO_PRICE != 0 || price < 1000)
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.");
    }

    private static List<Lotto> getLottos(int numOfLotto) throws Exception {
        List<Lotto> result = new ArrayList<>();
        for (int i=0; i<numOfLotto; i++) {
            result.add(getLotto());
        }
        return result;
    }

    private static Lotto getLotto() throws Exception {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
    private static int getNumOfLotto(int price) {
        return price/ONE_LOTTO_PRICE;
    }

}
