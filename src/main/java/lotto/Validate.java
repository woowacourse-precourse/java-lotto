package lotto;

import constant.LottoRule;
import constant.Text;

import java.util.HashSet;
import java.util.List;

public class Validate {

    public void validDivisible(int purchasePrice, int unitPrice) {
        if (purchasePrice % unitPrice != 0) {
            throw new IllegalArgumentException(
                    Text.ERROR + "입력값이 " + unitPrice + "으로 나누어떨어지지 않습니다.");
        }
    }

    public void validWinLottoForm(String[] splitInput) {
        if (splitInput.length != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(
                    Text.ERROR + "입력값을 로또 형태로 전환할 수 없습니다.");
        }
    }

    public void validLottoNumber(int number) {
        if (number < LottoRule.START_NUMBER.getValue() || LottoRule.END_NUMBER.getValue() < number) {
            throw new IllegalArgumentException(
                    Text.ERROR + "로또 번호의 범위를 넘어갔습니다. 로또 번호는 " +
                            LottoRule.START_NUMBER + "부터 " + LottoRule.END_NUMBER + "까지 입니다.");
        }
    }

    public void validDuplicate(List<Integer> winLottoNumbers) {
        if (new HashSet<>(winLottoNumbers).size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(
                    Text.ERROR + "중복된 로또 번호가 존재합니다.");
        }
    }
}
