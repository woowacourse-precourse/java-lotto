package lotto.domain;


import static lotto.domain.LottoConstant.*;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(String.format("보너스 번호는 %d ~ %d 사이의 숫자만 입력가능합니다.", LOTTO_MIN_RANGE,
                    LOTTO_MAX_RANGE));
        }
    }

    public boolean isContain(Lotto lotto) {
        return lotto.contains(number);
    }
}
