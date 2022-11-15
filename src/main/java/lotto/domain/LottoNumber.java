package lotto.domain;

import java.util.List;

public class LottoNumber {
    private int number;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;

    public LottoNumber(Lotto winningNumber, int number) {
        validate(winningNumber.getLottoNumber(), number);
        this.number = number;
    }

    public void validate(List<Integer> winningNumber, int bonusNumber) {
        if (isDuplicate(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호와 보너스 숫자가 중복입니다.");
        } else if (!isNumberRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 숫자가 1-45 사이가 아닙니다.");
        }
    }

    private Boolean isDuplicate(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }

    private Boolean isNumberRange(int bonusNumber) {
        return bonusNumber >= LOTTO_MIN_NUMBER && bonusNumber <= LOTTO_MAX_NUMBER;
    }

    public Integer getLottoNumber() {
        return this.number;
    }
}
