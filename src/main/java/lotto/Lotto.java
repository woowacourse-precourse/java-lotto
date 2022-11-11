package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public int size() {
        return numbers.size();
    }

    public int get(int order) {
        return numbers.get(order);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
