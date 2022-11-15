package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortList(numbers);
    }

    private List<Integer> sortList(List<Integer> numbers){
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }

    private void validate(List<Integer> numbers) {
        LottoException lottoException = new LottoException();
        lottoException.validate(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
