package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<Lotto> lottoNumbers;
    private final EnumMap<LottoStatus, Integer> lottoStatusQuantity;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        this.lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
        Arrays.stream(LottoStatus.values())
                .forEach(lottoStatus -> lottoStatusQuantity.putIfAbsent(lottoStatus, 0));
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
        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + 1);
    }


    public int getStatusCount(LottoStatus lottoStatus) {
        return lottoStatusQuantity.getOrDefault(lottoStatus, 0);
    }

    void addAllStatus(Lotto targetLotto, int bonusNumber) {
        lottoNumbers.stream()
                .map(lotto -> lotto.matchLotto(targetLotto, bonusNumber))
                .forEach(this::addStatus);
    }

    public boolean contains(Lotto lotto) {
        return lottoNumbers.contains(lotto);
    }

    public int getProfitSum() {
        return lottoStatusQuantity.entrySet().stream()
                .map(entry -> entry.getKey().getProfit() * entry.getValue())
                .reduce(Integer::sum).orElse(0);
    }

    public String getPurchaseDetails() {
        return lottoNumbers.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getResult(Lotto targetLotto, int bonusNumber) {
        addAllStatus(targetLotto, bonusNumber);
        return lottoStatusQuantity.entrySet().stream()
                .filter(lottoStatusEntry -> !lottoStatusEntry.getKey().equals(LottoStatus.MATCH_UNSATISFIED))
                .map(lottoStatusEntry -> lottoStatusEntry.getKey().getDescription() + " - " + lottoStatusEntry.getValue()
                        + "개")
                .collect(Collectors.joining("\n"));
    }
}
