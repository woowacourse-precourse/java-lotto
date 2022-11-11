package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.policy.LottoPolicy.COUNTS_OF_LOTTO_NUMBERS;
import static lotto.domain.policy.LottoPolicy.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.policy.LottoPolicy.MIN_NUMBER_OF_LOTTO;
import static lotto.domain.policy.LottoPolicy.PRICE_OF_LOTTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto_numbers.Lotto;
import lotto.domain.winning.LottoPurchaser;

public class LottoStore {

    static final String INVALID_VALUE_OF_MONEY = "1_000원 단위로만 입력해 주세요.";

    // 구매자로 반환해도 될것같음.
    public LottoPurchaser lottos(String strMoney) {
        int money = Integer.parseInt(strMoney);  // 아무래도 사용하는 쪽에서 알맞게 변경하는게..
        validateMoney(money);

        int quantityToBuy = money / PRICE_OF_LOTTO;
        return new LottoPurchaser(
                IntStream.range(0, quantityToBuy)
                        .mapToObj(i -> newLotto())  // 좀 더 나은 방법은 없을까 생각해보자.
                        .collect(Collectors.toList())
        );
    }

    private Lotto newLotto() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(
                MIN_NUMBER_OF_LOTTO,
                MAX_NUMBER_OF_LOTTO,
                COUNTS_OF_LOTTO_NUMBERS
        );

        return new Lotto(lottoNumbers);
    }

    private void validateMoney(int money) {
        if (money % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_VALUE_OF_MONEY);
        }
    }
}
