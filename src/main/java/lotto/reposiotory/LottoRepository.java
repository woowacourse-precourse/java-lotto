package lotto.reposiotory;

import lotto.Lotto;

import java.util.*;

public class LottoRepository extends Repository {
    private static final LottoRepository LOTTO_REPOSITORY = new LottoRepository();

    private LottoRepository() {
        super(new ArrayList<>());
    }

    public static LottoRepository createRepository() {
        return LOTTO_REPOSITORY;
    }

    public int getSize() {
        return findAll().size();
    }
}
