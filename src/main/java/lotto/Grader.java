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

    public void grade() {
        lottoList.forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchNumber = getMatchNumber(lottoNumbers);

        });
    }

    public int getMatchNumber(List<Integer> lottoNumbers) {
        int result = 0;
        for (int lottoNum : lottoNumbers) {
            if(answer.contains(lottoNum)) result++;
        }
        return result;
    }

}