package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_NUMBER_LOWER_LIMIT = 1;
    private static final int LOTTO_NUMBER_UPPER_LIMIT = 45;
    private static final int LOTTO_NUMBER_QUANTITY = 6;
    private static final String MONEY_SHOULD_BE_DIVIDED_BY_ONE_THOUSAND = "[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.";

    private List<Lotto> lottos = new ArrayList<>();
    private int lottoQuantity;

    public LottoGenerator(int money) {
        validateMoney(money);
        lottoQuantity = money / LOTTO_PRICE;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_SHOULD_BE_DIVIDED_BY_ONE_THOUSAND);
        }
    }

    public List<Lotto> generateLottos() {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT, LOTTO_NUMBER_QUANTITY);
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
