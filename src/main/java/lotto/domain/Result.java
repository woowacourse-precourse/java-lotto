package lotto.domain;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class Result {
    Integer[] result = {0, 0, 0, 0, 0};

    public void CalculateResult(User user) {
        List<Lotto> myLotto = user.GetMyLotto();
        List<Integer> answerLottoNumber = user.GetLottoAnswer();
        int bonusNumber = user.GetBonusNumber();

        for (Lotto e : myLotto) {
            List<Integer> currentLottoNumber = e.GetLottoNumber();
            CompareNumber(currentLottoNumber, bonusNumber, answerLottoNumber);
        }
    }

    public void CompareNumber(List<Integer> myLottoNumber, int bonusNumber, List<Integer> answerLottoNumber) {
        int correct = 0;
        boolean bonusCorrect = false;

        for (int e : myLottoNumber) {
            if (answerLottoNumber.contains(e)) correct++;
        }

        if (myLottoNumber.contains(bonusNumber)) bonusCorrect = true;
        Rank(correct, bonusCorrect);
    }

    public void Rank(int correct, boolean bonusCorrect) {
        if (correct == 6) result[4]++;
        if (correct == 5 && bonusCorrect) result[3]++;
        if (correct == 5 && !bonusCorrect) result[2]++;
        if (correct == 4) result[1]++;
        if (correct == 3) result[0]++;

    }

    public List<Integer> GetResult() {
        return Arrays.asList(result);
    }
}
