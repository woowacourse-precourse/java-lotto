package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;

    public LottoList() {
        this.lottoList = new ArrayList<>();
    }

    public void createLotto(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottoList.add(Lotto.createRandomNumbers());
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
