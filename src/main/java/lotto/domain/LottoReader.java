package lotto.domain;

import java.util.List;

public class LottoReader {

    public int countMatchingNumber(Lotto lotto, Lotto compareLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int)lottoNumbers.stream()
                .filter((lottoNumber) -> isIncludedNumber(compareLotto, lottoNumber))
                .count();
    }

    public boolean isIncludedNumber(Lotto lotto, int number) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(number);
    }
}
