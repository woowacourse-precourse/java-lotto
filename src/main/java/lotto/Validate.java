package lotto;

import constant.Amount;
import constant.LottoText;

public class Validate {
//    NULL("입력값은 null일 수 없습니다."),
//    NOT_INT("입력값이 정수가 아닙니다."),
//    NOT_DIVISIBLE(),
//    NOT_LOTTO_FORM("입력값을 로또 형태로 전환할 수 없습니다."),
//    DUPLICATE_LOTTO("중복된 값이 있습니다."),
//    DUPLICATE_BONUS("보너스 번호가 당첨 번호와 중복되었습니다."),
    public void validDivisible(int purchasePrice) {
        if (purchasePrice % Amount.UNIT.getPrice() != 0) {
            throw new IllegalArgumentException(LottoText.ERROR + "입력값을" + Amount.UNIT + "로 나눌 수 없습니다.");
        }
    }
}
