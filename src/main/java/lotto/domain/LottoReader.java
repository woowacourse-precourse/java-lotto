package lotto.domain;

import java.util.List;

public class LottoReader {
    public boolean isIncludedNumber(Lotto lotto, int number) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(number);
    }
}
