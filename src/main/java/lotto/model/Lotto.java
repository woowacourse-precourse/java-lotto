package lotto.model;

import java.util.List;
import lotto.ErrorControl;

public class Lotto {
    private final List<Integer> numbers;
    int prize;
    int prizeMoney;


    public Lotto(List<Integer> numbers) {
        ErrorControl errorControl = new ErrorControl();
        errorControl.validate(numbers);
        errorControl.validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    void addPrize(int prize) {
        this.prize = prize;
    }

    void addPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    int getPrize() {
        return prize;
    }

    int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
