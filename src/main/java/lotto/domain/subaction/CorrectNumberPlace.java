package lotto.domain.subaction;

import java.util.List;

public class CorrectNumberPlace {
    public int getCorrectCount(List<Integer> winningNumbers, int correctNumberCheck,
            List<Integer> randomNumber) {

        for (int winningNumber : winningNumbers) {
            if (randomNumber.contains(winningNumber)) {
                correctNumberCheck++;
            }
        }
        return correctNumberCheck;
    }
}