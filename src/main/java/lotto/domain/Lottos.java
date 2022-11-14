package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResults compareToLottoNumbers(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> winningLottoNumberMatchCountResults = winningLottoNumberMatchCount(winningLotto);
        List<Boolean> bonusNumberMatchCountResults = bonusNumberMatchCount(bonusNumber);
        return new LottoResults(getLottoResults(winningLottoNumberMatchCountResults, bonusNumberMatchCountResults));
    }

    private List<LottoRank> getLottoResults(List<Integer> winningLottoNumberMatchCountResults, List<Boolean> bonusNumberMatchCountResults) {
        List<LottoRank> lottoResults = new ArrayList<>();
        for (int i = 0; i < winningLottoNumberMatchCountResults.size(); i++) {
            lottoResults.add(LottoRank.getLottoRank(winningLottoNumberMatchCountResults.get(i), bonusNumberMatchCountResults.get(i)));
        }
        return lottoResults;
    }

    private List<Integer> winningLottoNumberMatchCount(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.compareToLottoNumbers(winningLotto))
                .collect(Collectors.toList());
    }

    private List<Boolean> bonusNumberMatchCount(BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.contains(bonusNumber))
                .collect(Collectors.toList());
    }
}
