package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static int BonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void Bonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String Bonus = Console.readLine();
        BonusNumber = Integer.parseInt(Bonus);
        BonusValidate(BonusNumber,numbers);
    }

    private void BonusValidate(int BonusNumber, List<Integer> numbers) {
        if (numbers.contains(BonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

}
