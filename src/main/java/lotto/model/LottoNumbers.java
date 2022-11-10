package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

class LottoNumbers {
    private final EnumMap<LottoStatus, Integer> lottoStatusQuantity;
    private final List<Lotto> lottoNumbers;

    public LottoNumbers() {
        this.lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
        this.lottoNumbers = new ArrayList<>();
    }

    void addLotto(int n) {
        while (n > 0) {
            Lotto lotto = new Lotto(RandomNumbersGenerator.creatSixDifferentNumbers());
            lottoNumbers.add(lotto);
            --n;
        }
    }

    public void addStatus(LottoStatus lottoStatus) {
        lottoStatusQuantity.putIfAbsent(lottoStatus, 0);
        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + 1);
    }


    public int getStatusCount(LottoStatus lottoStatus) {
        return lottoStatusQuantity.getOrDefault(lottoStatus, 0);
    }

    public int getLottoQuantity() {
        return lottoNumbers.size();
    }
}
