package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class BonusNumber {
    private final int bonusNumbers;

    public BonusNumber(List<Integer> numbers, int bonusNumbers) {
        validate(numbers, bonusNumbers);
        this.bonusNumbers = bonusNumbers;
    }

    public int getBonusNumbers() {
        return bonusNumbers;
    }

    private void validate(List<Integer> numbers , int bonusNumber) {

        //숫자가 1~45 사이가 아닐때
        if (bonusNumber < 1 && bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        //당첨 번호와 일치 할 때
        if (numbers.contains(bonusNumber) == true) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 일치하지 않는 수를 입력해 주세요.");
        }

    }

    // TODO: 추가 기능 구현
}
