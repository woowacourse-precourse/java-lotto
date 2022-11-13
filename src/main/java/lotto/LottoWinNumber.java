package lotto;

import java.util.List;

public class LottoWinNumber {

    private final List<Integer> numbers;
    private final int bonusNum;
    public static final int price = 1000;

    public LottoWinNumber(List<Integer> numbers, int bonusNum) {
        validate(numbers, bonusNum);
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    private void validate(List<Integer> numbers, int bonusNum) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 총 6개 존재해야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException
                    ("[ERROR] 로또 당첨 번호는 1~45 범위 안 정수값이어야 합니다.");
            }
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위 안 정수값이어야 합니다.");
        }
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException
                ("[ERROR] 보너스 번호는 로또 당첨 번호와 다른 값이어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
