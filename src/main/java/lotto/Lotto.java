package lotto;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public int size() {
        return numbers.size();
    }

    public LottoNumber get(int order) {
        return numbers.get(order);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
