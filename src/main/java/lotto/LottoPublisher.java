package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 로또 발행을 담당하는 클래스
 */
public class LottoPublisher {

    public static List<Lotto> publishLottos(int money) {
        validateMultipleOfLottoCost(money);
        int lottoCount = money / Lotto.LOTTO_COST;

        List<Lotto> lottos = Stream.generate(() -> publishLotto()).limit(lottoCount)
                .collect(Collectors.toUnmodifiableList());

        return lottos;
    }

    public static Lotto publishLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private static void validateMultipleOfLottoCost(int money) {
        if (money % Lotto.LOTTO_COST != 0 || money / Lotto.LOTTO_COST == 0) {
            throw new IllegalArgumentException("구매 금액은 " + Lotto.LOTTO_COST + "의 배수여야 합니다");
        }
    }
}
