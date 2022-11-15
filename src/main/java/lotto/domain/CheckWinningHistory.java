package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class CheckWinningHistory {
    private final List<List<Integer>> lottoNumber;
    private final List<Integer> winningNum;
    private final int BonusNumber;
    private final List<Integer> allGrade = Arrays.asList(0, 0, 0, 0, 0);

    public CheckWinningHistory(List<List<Integer>> lottoNumber, List<Integer> winningNum, int BonusNumber) {
        //validate(lottoNumber);
        //validateWinningNum(winningNum);
        //validateBonusNum(BonusNumber);
        this.lottoNumber = lottoNumber;
        this.winningNum = winningNum;
        this.BonusNumber = BonusNumber;
    }

    private void validate(List<List<Integer>> lottoNumber) {
        if (6 == lottoNumber.get(0).size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNum(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNum(int BonusNumber) {
        if (winningNum.contains(BonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> checkingGrade() {
        for(int i = 0; i < lottoNumber.size(); i++) {
            int count = checkingEachLottoMatchingNumber(i);
            if (count >= 3) {
                grade(count, i);
            }
        }
        return allGrade;
    }

    private void grade(int count, int i) {
        if (count == 5 && lottoNumber.get(i).contains(BonusNumber)) {
            allGrade.set(4, allGrade.get(4) + 1);
            return;
        }
        allGrade.set(count - 3, allGrade.get(count - 3) + 1);
    }

    private int checkingEachLottoMatchingNumber(int i) {
        int count = 0;
        for (int j = 0; j < winningNum.size(); j++) {
            if (lottoNumber.get(i).contains(winningNum.get(j))) {
                count++;
            }
        }
        return count;
    }
}
