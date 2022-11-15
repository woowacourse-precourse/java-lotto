package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private final List<Lotto> lottos;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public Referee(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Grade> calculateGrades() {
        List<Grade> grades = new ArrayList<>();
        for(Lotto lotto : lottos) {
            int matchCount = getWinningNumberMatchCount(lotto);
            int bonusCount = getBonusNumberMatchCount(lotto);
            Grade grade = Grade.findingGrade(matchCount, bonusCount);
            if (grade != null) {
                grades.add(grade);
            }
        }
        return grades;
    }

    public int getWinningNumberMatchCount(Lotto lotto) {
        int winNumberMatchCount = 0;
        for (Integer winningNumber : winningNumbers.getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                winNumberMatchCount++;
            }
        }
        return winNumberMatchCount;
    }

    public int getBonusNumberMatchCount(Lotto lotto) {
        int bonusNumberMatchCount = 0;
        if (lotto.getNumbers().contains(bonusNumber)) {
            bonusNumberMatchCount++;
        }
        return bonusNumberMatchCount;
    }
}
