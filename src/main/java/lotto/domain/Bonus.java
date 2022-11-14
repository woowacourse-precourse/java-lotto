package lotto.domain;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(int number, List<Integer> LottoList) {
        validate(number, LottoList);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number, List<Integer> LottoList) {
        checkRange(number);
        checkDuplicate(number, LottoList);
    }

    private void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해 주세요.");
        }
    }

    private void checkDuplicate(int number, List<Integer> LottoList) {
        if (LottoList.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 숫자를 입력해 주세요.");
        }
    }
}
