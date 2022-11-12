package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReader {

    public Map<LottoResult, Integer> getLottoResults(List<Lotto> lottos, Lotto compareLotto, int bonusNumber) {
        Map<LottoResult, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoResult lottoResult = getLottoResult(lotto, compareLotto, bonusNumber);
            result.computeIfPresent(lottoResult,(key, value) ->value + 1);
            result.computeIfAbsent(lottoResult, key -> 1);
        }
        return result;
    }

    public LottoResult getLottoResult(Lotto lotto, Lotto compareLotto, int bonusNumber) {
        double matchingNumber = countMatchingNumber(lotto, compareLotto);
        if (matchingNumber == LottoResult.THIRD.getSameNumber() && isIncludedNumber(lotto, bonusNumber)) {
            matchingNumber += 0.5;
        }
        return LottoResult.getResult(matchingNumber);
    }

    public double countMatchingNumber(Lotto lotto, Lotto compareLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (double) lottoNumbers.stream()
                .filter((lottoNumber) -> isIncludedNumber(compareLotto, lottoNumber))
                .count();
    }

    public boolean isIncludedNumber(Lotto lotto, int number) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(number);
    }
}
