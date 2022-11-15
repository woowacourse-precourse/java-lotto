package lotto.domain;

import lotto.domain.enums.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {
    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;
    private final List<LottoResult> results;

    public LottoComparator(
            Lottos lottos,
            WinningLotto winningLotto,
            BonusNumber bonusNumber
    ) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.results = new ArrayList<>();
    }

    public LottoResults compare() {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNumbers);
            boolean isMatchBonus = isMatchBonusNumber(lottoNumbers);
            addLottoResult(matchCount, isMatchBonus);
        }
        return new LottoResults(results);
    }

    private int getMatchCount(List<Integer> lottoNumbers) {
        return winningLotto.getMatchCount(lottoNumbers);
    }

    private boolean isMatchBonusNumber(List<Integer> lottoNumbers) {
        return bonusNumber.isMatchBonusNumber(lottoNumbers);
    }

    private void addLottoResult(
            int matchCount,
            boolean isMatchBonus
    ) {
        results.add(LottoResult.of(matchCount, isMatchBonus));
    }
}
