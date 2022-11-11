package lotto;

import java.util.List;

public class Lottos {

    public List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }
}
