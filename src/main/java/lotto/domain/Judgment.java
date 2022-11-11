package lotto.domain;

import java.util.List;

public class Judgment {
    public final int firstCount;

    public Judgment(List<List<Integer>> collectionOfLottoNumbers, List<Integer>numbers, int bonusNumber) {
        this.firstCount = calculateFirst(collectionOfLottoNumbers, numbers);
    }

    private int calculateFirst(List<List<Integer>> collectionOfLottoNumbers, List<Integer>numbers) {
        int count = 0;
        for (List<Integer> lottoNumbers : collectionOfLottoNumbers) {
            if (correctCount(lottoNumbers, numbers) == 6) {
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
}
