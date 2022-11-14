package lotto.domain;

import lotto.domain.enums.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoCalculator(
            LottosGenerator lottos,
            WinningLotto winningLotto,
            BonusNumber bonusNumber
    ) {
        this.lottos = lottos.getLottos();
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResults calculate() {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNumbers);
            boolean isMatchBonus = isMatchBonusNumber(lottoNumbers);
            getLottoResult(lottoResults, matchCount, isMatchBonus);
        }
        return new LottoResults(lottoResults);
    }

    private int getMatchCount(List<Integer> lottoNumbers) {
        return winningLotto.getMatchCount(lottoNumbers);
    }

    private boolean isMatchBonusNumber(List<Integer> lottoNumbers) {
        return bonusNumber.isMatchBonusNumber(lottoNumbers);
    }

    private void getLottoResult(
            List<LottoResult> lottoResults,
            int matchCount,
            boolean isMatchBonus
    ) {
        lottoResults.add(LottoResult.of(matchCount, isMatchBonus));
    }
}
