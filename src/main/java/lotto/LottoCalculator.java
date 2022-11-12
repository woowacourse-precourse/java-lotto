package lotto;

import java.util.List;

public class LottoCalculator {

    public int countMatchNumber(Lotto lotto, Lotto winningLotto) {
        int matchCount = 0;
        List<Integer> lottoNum = lotto.getNumbers();
        List<Integer> winningNum = winningLotto.getNumbers();
        for (int i = 0; i < 6; i++) {
            if (lottoNum.get(i) == winningNum.get(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
