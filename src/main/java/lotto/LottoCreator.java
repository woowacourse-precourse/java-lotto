package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {

    private final int LOTTO_MIN_NUM = 1;
    private final int LOTTO_MAX_NUM = 45;
    private final int LOTTO_SIZE = 6;

    private List<Integer> createNumbers() {
        List<Integer> numbers;

        numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_SIZE);
        Collections.sort(numbers);
        return numbers;
    }

    public List<Lotto> createLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(createNumbers()));
        }
        return lottos;
    }
}
