package lotto.vo;

import java.util.List;

public class LottoOfAnswer  extends Lotto{
    private final int bonusNumber;

    public LottoOfAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateLottoOfAnswer(numbers,bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateLottoOfAnswer(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호에 보너스 번호는 들어갈 수 없습니다.");
        }
    }

    public boolean containBounus(int bonusNumber) {
        return this.bonusNumber == bonusNumber;
    }
}
