package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_COUNT = 6;

    private static final LottoRepository instance = new LottoRepository();
    private static final List<Lotto> store = new ArrayList<>();

    private LottoRepository() {
    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public void generateLottos(int countToGenerate) {
        clearStore();
        for (int generateCount = 0; generateCount < countToGenerate; generateCount++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT);
            Collections.sort(numbers);
            store.add(new Lotto(numbers));
        }
    }

    public List<Lotto> findAll() {
        return new ArrayList<>(store);
    }

    public void clearStore() {
        store.clear();
    }
}

