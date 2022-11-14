package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.MAX_NUMBER;
import static lotto.domain.lotto.Lotto.MIN_NUMBER;
import static lotto.domain.lotto.Lotto.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    static final int PRICE = 1000;

    private Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER,
                NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);

        int lottoCount = money / PRICE;
        return Stream.generate(this::createRandomLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("로또 구매 금액은 0보다 커야 합니다.");
        }

        if (money % PRICE != 0) {
            throw new IllegalArgumentException("로또 구앱 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
