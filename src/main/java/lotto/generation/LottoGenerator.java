package lotto.generation;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfLotto; count++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }
}
