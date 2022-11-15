package lotto;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public Integer[] calculatePrizeNumber(List<List<Integer>> purchaserNumbers, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> commonNumbers;
        Integer[] answerNumbers = {0, 0, 0, 0, 0};
        int totalPrize;
        for (List<Integer> purchaseNumber : purchaserNumbers) {
            commonNumbers = new ArrayList<>();

            for (int i = 0; i < purchaseNumber.size(); i++) {
                if (purchaseNumber.contains(winningNumbers.get(i))) {
                    commonNumbers.add(winningNumbers.get(i));
                }
            }
            countCorrectNumber(bonusNumber, commonNumbers, answerNumbers);
        }
        return answerNumbers;
    }

    private static void countCorrectNumber(int bonusNumber, List<Integer> commonNumbers, Integer[] answerNumbers) {
        if (commonNumbers.size() == 3) {
            answerNumbers[0] += 1;
        }
        if (commonNumbers.size() == 4) {
            answerNumbers[1] += 1;
        }
        if (commonNumbers.size() == 5) {
            answerNumbers[2] += 1;
        }
        if (commonNumbers.size() == 6 && commonNumbers.contains(bonusNumber)) {
            answerNumbers[3] += 1;
        }
        if (commonNumbers.size() == 6 && !commonNumbers.contains(bonusNumber)) {
            answerNumbers[4] += 1;
        }
    }

    public int sumPrize(Integer[] answerNumber) {
        int totalPrize;
        totalPrize = answerNumber[0] * 5000 + answerNumber[1] * 50000
                + answerNumber[2] * 1500000 + answerNumber[3] * 30000000 + answerNumber[4] * 2000000000;
        return totalPrize;
    }

    public double calculateRate(int totalPrize, int purchaseAmount) {
        double rate = (totalPrize / (double) purchaseAmount) * 100;
        return rate;
    }
}
