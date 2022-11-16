package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoCreator {

    private final int LOTTO_MIN_NUM = 1;
    private final int LOTTO_MAX_NUM = 45;
    private final int LOTTO_SIZE = 6;

    private final List<Lotto> lottos;

    public LottoCreator(int amount) {
        this.lottos = createLottos(amount);
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_SIZE));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    private List<Lotto> createLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(createNumbers()));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
