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

    void addLotto(Lotto lotto) {
        lottoNumbers.add(lotto);
    }

    void addRandomLotto(int n) {
        while (n > 0) {
            addLotto(Lotto.CreatRandomLotto());
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

    public void addAllStatus(Lotto targetLotto) {
        lottoNumbers.stream()
                .map(lotto -> lotto.matchLotto(targetLotto))
                .forEach(this::addStatus);
    }

    public boolean contains(Lotto lotto) {
        return lottoNumbers.contains(lotto);
    }
}
