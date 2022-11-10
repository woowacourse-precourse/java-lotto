package lotto.model;

import java.util.EnumMap;

class LottoSystem {

    private final EnumMap<LottoStatus, Integer> lottoStatusQuantity;

    LottoSystem() {
        this.lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
    }

    public void addStatus(LottoStatus lottoStatus) {
        lottoStatusQuantity.putIfAbsent(lottoStatus, 0);
        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + 1);
    }


    public int getStatusCount(LottoStatus lottoStatus) {
        return lottoStatusQuantity.getOrDefault(lottoStatus, 0);
    }
}
