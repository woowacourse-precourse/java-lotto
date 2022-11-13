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

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, LOTTO_SIZE);
        List<Integer> sortedNumber = new ArrayList<>(numbers);
        Collections.sort(sortedNumber);

        Collections.unmodifiableList(sortedNumber);

        return new Lotto(sortedNumber);
    }
}
