package lotto;

import util.Constant;
import util.Error;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> setLottoNumber = new HashSet<>(numbers);
        if(setLottoNumber.size() != Constant.NUMBERQUANTITY) {
            throw new IllegalArgumentException(Error.SAMENUMBER.getErrorMsg());
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
