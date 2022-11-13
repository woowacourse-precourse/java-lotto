package lotto.reposiotory;

import lotto.Lotto;

import java.util.*;

public class Repository {
    private static final List<Lotto> list = new ArrayList<>();
    private static final Repository repository = new Repository();

    private Repository() {
    }

    public static Repository createRepository() {
        return repository;
    }

    public void save(Lotto lotto) {
        list.add(lotto);
    }

    public void saveAll(List<Lotto> lottos) {
        list.addAll(lottos);
    }


    public List<Lotto> findAll() {
        return Collections.unmodifiableList(list);
    }
}
