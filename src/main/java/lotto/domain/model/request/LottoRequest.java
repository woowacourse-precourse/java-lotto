package lotto.domain.model.request;

import java.util.List;

public class LottoRequest {

    private final List<Integer> numbers;

    public LottoRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
