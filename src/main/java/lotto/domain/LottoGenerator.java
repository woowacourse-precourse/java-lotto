package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int lottoCount;

    public LottoGenerator(int price) {
        this.lottoCount = price / UserInterface.PRICE_UNIT;
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createOneLotto());
        }

        UserInterface.printPurchaseResult(lottoCount, lottos);
        return lottos;
    }

    private Lotto createOneLotto() {
        List<Integer> randomNumbers =
                new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

}
