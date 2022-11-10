package lotto;

import java.util.List;

public class LottoValidate {
    private static final int LOTTO_SIZE = 6;
    public void validate(List<Integer> numbers){
        lottoSizeValidate(numbers);
        lottoDuplicateValidate(numbers);
    }
    private void lottoSizeValidate(List<Integer> numbers){
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
    private void lottoDuplicateValidate(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
