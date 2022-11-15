package lotto.domain;

import java.util.List;
import lotto.view.Grade;

public class Judgement {
    private static final int FIRST_NUMBER = 6;
    private static final int SECOND_AND_THIRD_NUMBER = 5;
    private static final int FOURTH_NUMBER = 4;
    private static final int FIFTH_NUMBER = 3;
    private static final int SECOND_BONUS_NUMBER = 1;
    private static final int THIRD_BONUS_NUMBER = 0;
    public Judgement() {
    }

    private int countSameLotto(List<Integer> lottoNumbers, List<Integer> ticket){
        int count = 0;
        for (Integer number: ticket){
            if (lottoNumbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    private int countValidBonus(int bonusNumber, List<Integer> ticket){
        int count = 0;
        if (ticket.contains(bonusNumber)){
            count++;
        }
        return count;
    }
    public Grade findGradeByRank(int rank){
        for (Grade grade : Grade.values()){
            if (grade.getRank() == rank){
                return grade;
            }
        }
        return null;
    }

    public Grade findGrade(List<Integer> lottoNumbers, int bonusNumber, List<Integer> ticket){
        int correctLotto = countSameLotto(lottoNumbers, ticket);//TODO: 함수 길이 줄이기
        int correctBonus = countValidBonus(bonusNumber, ticket);
        if (correctLotto == FIRST_NUMBER){
            return Grade.FIRST;
        }
        if (correctLotto == SECOND_AND_THIRD_NUMBER && correctBonus == SECOND_BONUS_NUMBER){
            return Grade.SECOND;
        }
        if (correctLotto == SECOND_AND_THIRD_NUMBER){
            return Grade.THIRD;
        }
        if (correctLotto == FOURTH_NUMBER){
            return Grade.FOURTH;
        }
        if (correctLotto == FIFTH_NUMBER){
            return Grade.FIFTH;
        }
        return Grade.NOTHING;
    }
}
