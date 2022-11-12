package lotto;

import java.util.List;

public class LottoPurchaseInfo {

    private List<Lotto> lottoNumbers;
    private long purchaseMoney;

    public LottoPurchaseInfo(List<Lotto> lottoNumbers, long purchaseMoney) {

        this.lottoNumbers = lottoNumbers;
        this.purchaseMoney = purchaseMoney;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public long getPurchaseMoney() {
        return purchaseMoney;
    }
}
