package lotto.domain.subaction;

import java.util.List;

public class CorrectNumberPlace {
    public int getCorrectCount(List<Integer> WinningNumbers, int correctNumberCheck, List<Integer> randomNumber) {
        for (int winningNumber : WinningNumbers) {
            if (randomNumber.contains(winningNumber)) {
                correctNumberCheck++;
            }
        }
        return correctNumberCheck;
    }
}