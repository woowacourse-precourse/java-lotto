package lotto;

import java.util.List;

public class Judgement {

    public int correctCount(Lotto lotto, List<Integer> player) {
        int result = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (int playerNumber : player) {
            if (lottoNumbers.contains(playerNumber)) {
                result++;
            }
        }

        return result;
    }
}
