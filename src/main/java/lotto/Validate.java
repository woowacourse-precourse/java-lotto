package lotto;

import constant.Amount;
import constant.LottoRule;
import constant.LottoText;

import java.util.HashSet;
import java.util.List;

public class Validate {
//    DUPLICATE_BONUS("보너스 번호가 당첨 번호와 중복되었습니다."),
    public void validDivisible(int purchasePrice) {
        if (purchasePrice % Amount.UNIT.getPrice() != 0) {
            throw new IllegalArgumentException(
                    LottoText.ERROR + "입력값이 " + Amount.UNIT + "으로 나누어떨어지지 않습니다.");
        }
    }

    public void validWinLottoForm(String[] splitInput) {
        if (splitInput.length != LottoRule.COUNT.getValue()) {
            throw new IllegalArgumentException(
                    LottoText.ERROR + "입력값을 로또 형태로 전환할 수 없습니다.");
        }
    }

    public void validLottoNumber(int number) {
        if (number < LottoRule.START_NUMBER.getValue() || LottoRule.END_NUMBER.getValue() < number) {
            throw new IllegalArgumentException(
                    LottoText.ERROR + "로또 번호의 범위를 넘어갔습니다. 로또 번호는 " +
                            LottoRule.START_NUMBER + "부터 " + LottoRule.END_NUMBER + "까지 입니다.");
        }
    }

    public void validDuplicate(List<Integer> winLottoNumbers) {
        if (new HashSet<>(winLottoNumbers).size() != LottoRule.COUNT.getValue()) {
            throw new IllegalArgumentException(
                    LottoText.ERROR + "중복된 로또 번호가 존재합니다.");
        }
    }
}
