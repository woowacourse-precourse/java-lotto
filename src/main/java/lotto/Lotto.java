package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static int BonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    private void validateLottoRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numberDistinct = new HashSet<>(numbers);
        if (numberDistinct.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void askBonusNumber() {
        System.out.println("\n"+Constant.ASK_BONUS_NUMBER);
        String Bonus = Console.readLine();
        BonusNumber = Integer.parseInt(Bonus);

        validateNumberRange(BonusNumber);
        BonusValidate(BonusNumber,numbers);
    }

    private void BonusValidate(int BonusNumber, List<Integer> numbers) {
        if (numbers.contains(BonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
    }

}
