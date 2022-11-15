package lotto;

import static lotto.LottoNumberRange.MAX;
import static lotto.LottoNumberRange.MIN;
import static lotto.constant.StandardConstant.LOTTO_NUMBERS_COUNT_STANDARD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {

    public List<Lotto> createLottos(Quantity quantity) {

        int number = quantity.getNumber();
        int minRange = MIN.getValue();
        int maxRange = MAX.getValue();
        int count = LOTTO_NUMBERS_COUNT_STANDARD.getValue();

        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < number) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(minRange, maxRange, count);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }
}
