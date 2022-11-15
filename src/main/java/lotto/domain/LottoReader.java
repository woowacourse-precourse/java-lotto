package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReader {
    public static Map<LottoRanking, Integer> getLottoRankings(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRanking, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRanking lottoRanking = getLottoRanking(lotto, winningLotto);
            result.computeIfPresent(lottoRanking, (key, value) -> value + 1);
            result.computeIfAbsent(lottoRanking, key -> 1);
        }
        return result;
    }

    public static LottoRanking getLottoRanking(Lotto lotto, WinningLotto winningLotto) {
        double matchingNumber = countMatchingNumber(lotto, winningLotto.getWinningLotto());
        if (matchingNumber == LottoRanking.THIRD.getLottoScore() && isIncludedNumber(lotto, winningLotto.getBonusNumber())) {
            matchingNumber += 0.5;
        }
        return LottoRanking.getRanking(matchingNumber);
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
