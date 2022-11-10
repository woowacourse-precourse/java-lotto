package lotto.model;

import java.util.EnumMap;

class LottoSystem {

    private final EnumMap<LottoStatus, Integer> lottoStatusQuantity;
    private final LottoNumbers lottoNumbers;

    LottoSystem() {
        this.lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
        this.lottoNumbers = new LottoNumbers();
    }


    public void addAllStatus() {

    }

    public void addStatus(LottoStatus lottoStatus) {
        lottoStatusQuantity.putIfAbsent(lottoStatus, 0);
        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + 1);
    }


    public int getStatusCount(LottoStatus lottoStatus) {
        return lottoStatusQuantity.getOrDefault(lottoStatus, 0);
    }

    public void addLotto(int n) {
        lottoNumbers.addLotto(n);
    }

    public int getLottoQuantity() {
        return lottoNumbers.getLottoQuantity();
    }
}
