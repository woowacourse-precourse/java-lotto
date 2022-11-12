package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReader {

    public static Map<LottoResult, Integer> getLottoResults(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoResult, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoResult lottoResult = getLottoResult(lotto, winningLotto);
            result.computeIfPresent(lottoResult, (key, value) -> value + 1);
            result.computeIfAbsent(lottoResult, key -> 1);
        }
        return result;
    }

    public static LottoResult getLottoResult(Lotto lotto, WinningLotto winningLotto) {
        double matchingNumber = countMatchingNumber(lotto, winningLotto.getWinningLotto());
        if (matchingNumber == LottoResult.THIRD.getSameNumber() && isIncludedNumber(lotto, winningLotto.getBonusNumber())) {
            matchingNumber += 0.5;
        }
        return LottoResult.getResult(matchingNumber);
    }

    public static double countMatchingNumber(Lotto lotto, Lotto compareLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (double) lottoNumbers.stream()
                .filter((lottoNumber) -> isIncludedNumber(compareLotto, lottoNumber))
                .count();
    }

    public static boolean isIncludedNumber(Lotto lotto, int number) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(number);
    }
}
