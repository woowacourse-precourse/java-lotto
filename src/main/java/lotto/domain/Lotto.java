package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    protected final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
        lottoNumberSort();
        validate();
    }

    public static Lotto generator() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    private void lottoNumberSort() {
        Collections.sort(lotto);
    }

    private void validate() {
        sizeValidate();
        numberFormatValidate();
    }

    private void sizeValidate() {
        if (lotto.size() != LottoInfo.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리만 입력 가능합니다.");
        }
    }

    private void numberFormatValidate() {
        for (Integer number : lotto) {
            eachNumberFormatValidate(number);
        }
    }

    private void eachNumberFormatValidate(int number) {
        if (number > LottoInfo.MAX_NUMBER.getValue() || number < LottoInfo.MIN_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
