package lotto;

import java.util.List;

public class LottoValidate {
    private static final int LOTTO_SIZE = 6;
    public void validate(List<Integer> numbers){
        lottoSizeValidate(numbers);
    }
    private void lottoSizeValidate(List<Integer> numbers){
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
