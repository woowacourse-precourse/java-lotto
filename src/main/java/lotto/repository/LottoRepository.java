package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    public static final int LOTTO_PRICE = 1000;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int NUMBER_COUNT = 6;

    private static final LottoRepository instance = new LottoRepository();
    private static final List<Lotto> store = new ArrayList<>();

    private LottoRepository() {
    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public List<Lotto> generateLotto(final int validatedPrice) {
        int lottoCount = calculateLottoCount(validatedPrice);
        for (int count = 1; count <= lottoCount; count++) {
            store.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_COUNT)));
        }
        return Collections.unmodifiableList(store);
    }

    private int calculateLottoCount(final int validatedPrice) {
        return validatedPrice / LOTTO_PRICE;
    }

    public List<Lotto> findAll() {
        return Collections.unmodifiableList(store);
    }
}
