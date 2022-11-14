package lotto.domain;

import java.util.ArrayList;
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
        this.thirdCount = calculateThird(numbers);
        this.fourthCount = calculateFourth(numbers);
        this.fifthCount = calculateFifth(numbers);
    }

    private int calculateFirst(List<Integer>numbers) {
        int count = 0;
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < collectionOfLottoNumbers.size(); i++) {
            if (correctCount(collectionOfLottoNumbers.get(i), numbers) == 6) {
                check.add(i);
                count++;
            }
        }
        removeNumbers(check);
        return count;
    }

    private int calculateSecond(List<Integer>numbers, int bonusNumber) {
        int count = 0;
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < collectionOfLottoNumbers.size(); i++) {
            if (correctCountIncludingBonus(collectionOfLottoNumbers.get(i), numbers, bonusNumber)) {
                check.add(i);
                count++;
            }
        }
        removeNumbers(check);
        return count;
    }

    private int calculateThird(List<Integer>numbers) {
        int count = 0;
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < collectionOfLottoNumbers.size(); i++) {
            if (correctCount(collectionOfLottoNumbers.get(i), numbers) == 5) {
                check.add(i);
                count++;
            }
        }
        removeNumbers(check);
        return count;
    }

    private int calculateFourth(List<Integer>numbers) {
        int count = 0;
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < collectionOfLottoNumbers.size(); i++) {
            if (correctCount(collectionOfLottoNumbers.get(i), numbers) == 4) {
                check.add(i);
                count++;
            }
        }
        removeNumbers(check);
        return count;
    }

    private int calculateFifth(List<Integer>numbers) {
        int count = 0;
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < collectionOfLottoNumbers.size(); i++) {
            if (correctCount(collectionOfLottoNumbers.get(i), numbers) == 3) {
                check.add(i);
                count++;
            }
        }
        removeNumbers(check);
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

    private void removeNumbers(List<Integer> check) {
        for (int i = 0; i < check.size(); i++) {
            collectionOfLottoNumbers.remove(i);
        }
    }
}
