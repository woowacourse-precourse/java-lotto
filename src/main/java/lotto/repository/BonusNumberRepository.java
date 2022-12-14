package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;

public class BonusNumberRepository {
    private static final BonusNumberRepository instance = new BonusNumberRepository();
    private static final List<BonusNumber> store = new ArrayList<>();
    public static final int BONUS_NUMBER_INDEX = 0;

    private BonusNumberRepository() {
    }

    public static BonusNumberRepository getInstance() {
        return instance;
    }

    public BonusNumber save(final BonusNumber bonusNumber) {
        store.add(bonusNumber);
        return find();
    }

    public BonusNumber find() {
        return store.get(BONUS_NUMBER_INDEX);
    }

}
