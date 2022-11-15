package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;
    private Integer userAmount;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        bonusNumber = BonusNumber();
        userAmount = UserAmount();
        System.out.println(numbers);
        System.out.println(bonusNumber);
        System.out.println(userAmount);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private Integer BonusNumber() {
        bonusNumber = Randoms.pickNumberInRange(1, 45);
        while (numbers.contains(bonusNumber)) {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        }
        return bonusNumber;
    }

    private Integer UserAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        userAmount = Integer.parseInt(Console.readLine());
        return userAmount;
    }
}
