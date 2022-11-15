package lotto.reposiotory;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Repository {
    private List<Lotto> list;

    public Repository(List<Lotto> list) {
        this.list = list;
    }

    public void save(Lotto lotto) {
        list.add(lotto);
    }

    public void saveAll(List<Lotto> lottos) {
        list.addAll(lottos);
    }

    public void removeAll(){
        list.clear();
    }

    public List<Lotto> findAll() {
        return Collections.unmodifiableList(list);
    }

}
