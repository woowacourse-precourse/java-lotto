package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CreateWinningLotto {
    private final List<Integer> winningNumbers;

    public CreateWinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        HashSet<Integer> toCompare = new HashSet<>(winningNumbers);
        if(toCompare.size() != winningNumbers.size()) {
            throw new IllegalArgumentException();
        }

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
