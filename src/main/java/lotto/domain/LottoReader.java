package lotto.domain;

import java.util.List;

public class LottoReader {

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
