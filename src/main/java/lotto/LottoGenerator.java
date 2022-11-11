package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoList(int numOfLotto) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i<numOfLotto; i++){
            lotto.add(generateLotto());
        }

        return lotto;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
