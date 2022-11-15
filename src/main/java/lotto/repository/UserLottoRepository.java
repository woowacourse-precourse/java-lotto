package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class UserLottoRepository {
    private static UserLottoRepository instance;
    private static List<Lotto> lotteries;

    private UserLottoRepository() {
        lotteries = new ArrayList<>();
    }

    public static UserLottoRepository getInstance() {
        if (instance == null) {
            instance = new UserLottoRepository();
        }
        return instance;
    }

    public void save(Lotto lotto) {
        lotteries.add(lotto);
    }

    public List<Lotto> findAll() {
        return lotteries;
    }
}
