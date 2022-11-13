package lotto.model;

import lotto.model.Lotto;

import java.util.List;

public class Player {
    private int purchaseAmount;
    private int lottoCount;
    private List<Lotto> lottoNumbers;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void setLottoNumbers(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Lotto> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
