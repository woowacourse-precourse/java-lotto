package lotto.domain;

import java.util.List;

public class Judgement {
    private int matchedCount = 0;

    private void compareLottoWithLucky(List<Integer> lottoNumbers, List<Integer> luckyNumbers) {
        for (int number : lottoNumbers) {
            addMatchedCount(number, luckyNumbers);
        }
    }

    private void addMatchedCount(int number, List<Integer> luckyNumbers) {
        if (luckyNumbers.contains(number)) {
            matchedCount++;
        }
    }
}
