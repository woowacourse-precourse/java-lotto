package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private Lotto number;
    private Integer bonusNumber;

    public WinningLotto(String input, String bonusNumber) {
        validateDuplicate(input, bonusNumber);
        validateNumber(input, bonusNumber);
        this.number = number(input);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private Lotto number(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(",");
        for (String s : split) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    private void validateDuplicate(String input, String bonusNumber) {
        if (input.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스 번호는 달라야 합니다.");
        }
    }

    private void validateNumber(String input, String bonusNumber) {
        if (!input.matches("^(\\d?,){5}\\d?$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 ,만 입력해 주세요.");
        }

        if (!bonusNumber.matches("^\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
