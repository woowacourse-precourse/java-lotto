package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_LOWER_LIMIT = 1;
    private static final int LOTTO_NUMBER_UPPER_LIMIT = 45;
    private static final int LOTTO_NUMBER_QUANTITY = 6;

    private List<Lotto> lottos = new ArrayList<>();
    private int lottoQuantity;

    public LottoGenerator(int money) {
        lottoQuantity = money / 1000;
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
}
