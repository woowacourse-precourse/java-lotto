package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> lottos;
    private int lottoCount;

    public LottoStore(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }
        this.lottos = lottos;
        this.lottoCount = count;
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void compareAllLottos(List<Integer> inputNumbers) {
        for (Lotto lotto : lottos) {
            lotto.compareLotto(inputNumbers);
        }
    }
}
