package lotto;

import java.util.List;

public class Grader {
    List<Lotto> lottoList;
    List<Integer> answer;
    int bonusNumber;

    public Grader(List<Lotto> lottoList, List<Integer> answer, int bonusNumber) {
        this.lottoList = lottoList;
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

}