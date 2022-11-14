package lotto.domain;

import java.util.List;

public class Judgment {

    public List<List<Integer>> collectionOfLottoNumbers;
    public final int firstCount;
    public final int secondCount;
    public final int thirdCount;
    public final int fourthCount;
    public final int fifthCount;

    public Judgment(List<List<Integer>> collectionOfLottoNumbers, List<Integer>numbers, int bonusNumber) {
        this.collectionOfLottoNumbers = collectionOfLottoNumbers;
        this.firstCount = calculateFirst(numbers);
        this.secondCount = calculateSecond(numbers, bonusNumber);
        this.thirdCount = calculateThird(numbers, bonusNumber);
        this.fourthCount = calculateFourth(numbers);
        this.fifthCount = calculateFifth(numbers);
    }

    private int calculateFirst(List<Integer>numbers) {
        int count = 0;
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            if (correctCount(collectionOfLottoNumber, numbers) == 6) {
                count++;
            }
        }
        return count;
    }

    private int calculateSecond(List<Integer>numbers, int bonusNumber) {
        int count = 0;
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            if (correctCountIncludingBonus(collectionOfLottoNumber, numbers, bonusNumber)) {
                count++;
            }
        }
        return count;
    }

    private int calculateThird(List<Integer>numbers, int bonusNumber) {
        int count = 0;
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            if (correctCount(collectionOfLottoNumber, numbers) == 5 && !correctCountIncludingBonus(
                    collectionOfLottoNumber, numbers, bonusNumber)) {
                count++;
            }
        }
        return count;
    }

    private int calculateFourth(List<Integer>numbers) {
        int count = 0;
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            if (correctCount(collectionOfLottoNumber, numbers) == 4) {
                count++;
            }
        }
        return count;
    }

    private int calculateFifth(List<Integer>numbers) {
        int count = 0;
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            if (correctCount(collectionOfLottoNumber, numbers) == 3) {
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
