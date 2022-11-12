package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final List<Integer> numbers;
    private final int bonusNum;

    public LottoTicket(List<Integer> numbers, int bonusNum) {
        validate(numbers, bonusNum);
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    private void validate(List<Integer> numbers, int bonusNum) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum(){
        return bonusNum;
    }
}
