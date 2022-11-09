package lotto.domain.lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    static final String INVALID_VALUE_OF_MONEY = "1_000원 단위로만 입력해 주세요.";

    private static final int PRICE_OF_LOTTO = 1_000;
    private static final int MIN_NUMBER_OF_LOTTO = 1;
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private static final int COUNT_OF_LOTTO_NUMBERS = 6;

    public List<Lotto> lottos(String strMoney) {
        int money = Integer.parseInt(strMoney);  // 아무래도 사용하는 쪽에서 알맞게 변경하는게..
        validateMoney(money);

        int quantityToBuy = money / PRICE_OF_LOTTO;

        return IntStream.range(0, quantityToBuy)
                .mapToObj(i -> newLotto())  // 좀 더 나은 방법은 없을까 생각해보자.
                .collect(Collectors.toList());
    }

    private Lotto newLotto() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(
                MIN_NUMBER_OF_LOTTO,
                MAX_NUMBER_OF_LOTTO,
                COUNT_OF_LOTTO_NUMBERS
        );

        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private void validateMoney(int money) {
        if (money % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_VALUE_OF_MONEY);
        }
    }
}
