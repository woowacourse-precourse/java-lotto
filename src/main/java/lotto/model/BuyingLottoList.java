package lotto.model;

import java.util.List;

public class BuyingLottoList {

    private final List<Lotto> lottoList;
    private final int numberOfLotto;

    public BuyingLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.numberOfLotto = lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }
}
