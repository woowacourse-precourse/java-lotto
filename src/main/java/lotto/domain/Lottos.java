package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Lottos implements Iterable<Lotto> {
    private final int size;
    private final List<Lotto> lottos;
    private Map<LottoRank, Integer> ranks;
    private LottoResult result;

    public Lottos(List<Lotto> lottos) {
        this.size = lottos.size();
        this.lottos = lottos;
    }


    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public int size() {
        return lottos.size();
    }

    public void setRanks(Map<LottoRank, Integer> ranks) {
        this.ranks = ranks;
    }

    public void setResult(LottoResult result) {
        this.result = result;
    }

}
