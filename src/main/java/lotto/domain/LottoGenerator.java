package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> createLottos(int lottoCount) {
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
