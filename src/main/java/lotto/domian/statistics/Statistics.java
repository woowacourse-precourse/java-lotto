package lotto.domian.statistics;

import java.util.List;

public class Statistics {

    public int countCorrectNumbers(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }
}
