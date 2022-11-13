package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.request.MoneyRequest;

public class LottoGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int DIVIDED_NUMBER = 1000;

    private final Lottos lottos;

    public LottoGenerator(MoneyRequest moneyRequest) {
        int quantity = getAvailableQuantity(moneyRequest.getMoney());
        this.lottos = createLotto(quantity);
    }

    private Lottos createLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int number = 1; number < quantity; number++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_COUNT);
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
        return new Lottos(lottos);
    }

    private int getAvailableQuantity(int money) {
        return Math.floorDiv(money, DIVIDED_NUMBER);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
