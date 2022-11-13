package lotto;

import java.util.List;

public class LottoWinNo {

    private final List<Integer> numbers;
    private final int bonusNum;
    public static final int price=1000;

    public LottoWinNo(List<Integer> numbers, int bonusNum) {
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
