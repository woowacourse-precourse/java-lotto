package lotto.reposiotory;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class PrizeRepository extends Repository {
    private static final List<Lotto> list = new ArrayList<>();

    private static final Repository PRIZE_REPOSITORY = new PrizeRepository();

    private PrizeRepository() {
        super(list);
    }

    public static Repository createRepository() {
        return PRIZE_REPOSITORY;
    }
}
