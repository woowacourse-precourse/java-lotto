package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWrapper {
    private List<Lotto> lottoWrapper = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoWrapper.add(lotto);
    }

    public int size() {
        return lottoWrapper.size();
    }

    public Lotto get(int index) {
        return lottoWrapper.get(index);
    }

    public void printAllLotto() {
        lottoWrapper.forEach(Lotto::printLottoInfo);
    }
}
