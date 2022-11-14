package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    protected final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lottoNumberSort(lotto);
        validate();
    }

    public static Lotto generator() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    private List<Integer> lottoNumberSort(List<Integer> lotto) {
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    private void validate() {
        sizeValidate();
        numberFormatValidate();
        overlapValidate();
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

    private void overlapValidate() {
        if (lotto.stream().distinct().count() != LottoInfo.LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중되지 않아야 합니다.");
        }

    }
}
