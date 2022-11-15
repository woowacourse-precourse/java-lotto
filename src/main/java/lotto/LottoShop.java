package lotto;

import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.Constants.WINNING_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_PRICE = 1_000;

    public static List<Lotto> purchase(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.getAmount() >= LOTTO_PRICE) {
            lottos.add(issueLotto());
            money = money.decreaseAmount(LOTTO_PRICE);
        }
        return lottos;
    }

    private static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, WINNING_NUMBERS_SIZE);
        return new Lotto(numbers);
    }
}
