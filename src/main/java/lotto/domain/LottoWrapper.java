package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWrapper {
    private List<Lotto> lottoWrapper = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoWrapper.add(lotto);
    }

    public long size() {
        return lottoWrapper.size();
    }
}
