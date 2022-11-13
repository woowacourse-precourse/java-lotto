package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    private Result() {
    }

    private Result(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Result of(List<Integer> winningNumbers, int bonusNumber) {
        return new Result(winningNumbers, bonusNumber);
    }
}
