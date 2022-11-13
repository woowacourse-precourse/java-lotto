package lotto.service;

import java.util.HashSet;
import java.util.List;
import lotto.model.LottoPrice;
import lotto.model.LottoRule;

public class Validate {

    public void validPurchasePriceAboveThanUnitPrice(int purchasePrice) {
        if (purchasePrice < LottoPrice.UNIT.getPrice()) {
            throw new IllegalArgumentException("입력값이 " + LottoPrice.UNIT + "보다 낮습니다. 로또를 구매할 수 없습니다.");
        }
    }

    public void validDivisible(int purchasePrice) {
        if (purchasePrice % LottoPrice.UNIT.getPrice() != 0) {
            throw new IllegalArgumentException("입력값이 " + LottoPrice.UNIT + "으로 나누어떨어지지 않습니다.");
        }
    }

    public void validWinLottoForm(String[] splitInput) {
        if (splitInput.length != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("입력값을 로또 형태로 전환할 수 없습니다.");
        }
    }

    public void validLottoNumber(int number) {
        if (number < LottoRule.START_NUMBER.getValue() || LottoRule.END_NUMBER.getValue() < number) {
            throw new IllegalArgumentException("로또 번호의 범위를 넘어갔습니다. 로또 번호는 " +
                    LottoRule.START_NUMBER + "부터 " + LottoRule.END_NUMBER + "까지 입니다.");
        }
    }

    public void validDuplicate(List<Integer> winLottoNumbers) {
        if (new HashSet<>(winLottoNumbers).size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }
}
