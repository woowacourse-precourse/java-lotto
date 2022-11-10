package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

class LottoNumbers {

    private final List<Lotto> lottoNumbers;
    private final EnumMap<LottoStatus, Integer> lottoStatusQuantity;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        this.lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
    }

    public int getAllStatusCount() {
        return lottoStatusQuantity.values().stream()
                .reduce(Integer::sum).orElse(0);
    }

    void addLotto(int n) {
        while (n > 0) {
            lottoNumbers.add(Lotto.CreatRandomLotto());
            --n;
        }
    }

    public int getLottoQuantity() {
        return lottoNumbers.size();
    }

    public void addStatus(LottoStatus lottoStatus) {
        lottoStatusQuantity.putIfAbsent(lottoStatus, 0);
        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + 1);
    }


    public int getStatusCount(LottoStatus lottoStatus) {
        return lottoStatusQuantity.getOrDefault(lottoStatus, 0);
    }

    public void addAllStatus() {
    }
}
