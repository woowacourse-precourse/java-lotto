package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Judgement {
    private int matchedCount = 0;
    private int matchedBonus = 0; // 0일 경우 unmatched, 1일 경우 macthed

    public List<Integer> getRanking(List<Integer> lottoNumbers, List<Integer> luckyNumbers, int bonusNumber) {
        compareLottoWithLucky(lottoNumbers, luckyNumbers);
        compareLottoWithBonus(lottoNumbers, bonusNumber);
        return Arrays.asList(matchedCount, matchedBonus);
    }

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

    private void compareLottoWithBonus(List<Integer> lottoNumbers, int bonusNumber) {
        for (int number : lottoNumbers) {
            checkMatchedBonus(number, bonusNumber);
        }
    }

    private void checkMatchedBonus(int number, int bonusNumber) {
        if (number == bonusNumber) {
            matchedBonus = 1;
        }
    }
}
