package lotto.controller;

import java.util.List;
import lotto.utils.Grade;

public class Judgement {
    private static int countSameLotto(List<Integer> lottoNumbers, List<Integer> ticket) {
        int count = 0;
        for (Integer number : ticket) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static int countValidBonus(int bonusNumber, List<Integer> ticket) {
        int count = 0;
        if (ticket.contains(bonusNumber)) {
            count++;
        }
        return count;
    }

    public static Grade findGradeByRank(int rank) {
        for (Grade grade : Grade.values()) {
            if (grade.getRank() == rank) {
                return grade;
            }
        }
        return Grade.NOTHING;
    }

    public static Grade findGradeByCorrectNumber(List<Integer> lottoNumbers, int bonusNumber, List<Integer> ticket) {
        int correctLotto = countSameLotto(lottoNumbers, ticket);
        int correctBonus = countValidBonus(bonusNumber, ticket);
        if (Grade.SECOND.getCorrectBonus() == correctBonus
                && Grade.SECOND.getCorrectLotto() == correctLotto) {
            return Grade.SECOND;
        }
        for (Grade grade : Grade.values()) {
            if (grade.getCorrectLotto() == correctLotto) {
                return grade;
            }
        }
        return Grade.NOTHING;
    }
}
