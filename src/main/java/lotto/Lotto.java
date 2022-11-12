package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    // sorting numbers


    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // match checking
    public void matchResult(List<Integer> list, int wildCard, int[] result){
        // Exception 처리
        // 1. 서로 크기가 다른 경우
        int _cnt = 0;
        for(int w : numbers){
            if(list.contains(w)) _cnt++;
        }
        int idx = _cnt;
        if(idx == 5 && !numbers.contains(wildCard)) idx--;
        result[idx]++;
    }

    // for bonus card checking
    public boolean matchBonusNum(int num){
        return numbers.contains(num);
    }
}
