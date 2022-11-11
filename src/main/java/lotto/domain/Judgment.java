package lotto.domain;

import java.util.List;

public class Judgment {

    public List<List<Integer>> collectionOfLottoNumbers;
    public final int firstCount;
    public final int secondCount;

    public Judgment(List<List<Integer>> collectionOfLottoNumbers, List<Integer>numbers, int bonusNumber) {
        this.collectionOfLottoNumbers = collectionOfLottoNumbers;
        this.firstCount = calculateFirst(numbers);
        this.secondCount = calculateSecond(numbers, bonusNumber);
    }

    private int calculateFirst(List<Integer>numbers) {
        int count = 0;
        for (List<Integer> lottoNumbers : collectionOfLottoNumbers) {
            if (correctCount(lottoNumbers, numbers) == 6) {
                collectionOfLottoNumbers.remove(lottoNumbers);
                count++;
            }
        }
        return count;
    }

    private int calculateSecond(List<Integer>numbers, int bonusNumber) {
        int count = 0;
        for (List<Integer> lottoNumbers : collectionOfLottoNumbers) {
            if (correctCountIncludingBonus(lottoNumbers, numbers, bonusNumber)) {
                collectionOfLottoNumbers.remove(lottoNumbers);
                count++;
            }
        }
        return count;
    }

    public int correctCount(List<Integer> actualNumbers, List<Integer> expectedNumbers) {
        int count = 0;
        int[] checkCorrect = new int[46];
        for (Integer actualNumber : actualNumbers) {
            checkCorrect[actualNumber] = 1;
        }
        for (Integer expectedNumber : expectedNumbers) {
            if (checkCorrect[expectedNumber] == 1) {
                count++;
            }
        }
        return count;
    }

    public boolean correctCountIncludingBonus(List<Integer> actualNumbers, List<Integer> expectedNumbers, int bonusNumber) {
        if (matchBonusNumber(actualNumbers, bonusNumber) ) {
            return correctCount(actualNumbers, expectedNumbers) == 5;
        }
        return false;
    }

    private boolean matchBonusNumber(List<Integer> actualNumbers, int bonusNumber) {
        for (Integer actualNumber : actualNumbers) {
            if (bonusNumber == actualNumber) {
                return true;
            }
        }
        return false;
    }
}
