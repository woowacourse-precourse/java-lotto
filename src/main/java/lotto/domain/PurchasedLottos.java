package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.ConstValue.*;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public PurchasedLottos(int count) {
        generateLottos(count);
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, LOTTO_SIZE);
        Collections.unmodifiableList(numbers);

        return new Lotto(numbers);
    }
}
