package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLottos(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(this.generate());
        }
        return lottos;
    }

    private Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER.getNumber(),
                Constants.MAX_LOTTO_NUMBER.getNumber(), Constants.LOTTO_NUMBER_COUNT.getNumber());
        return new Lotto(numbers);
    }
}
