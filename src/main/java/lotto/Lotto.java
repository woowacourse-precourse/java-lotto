package lotto;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateOverlap(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            if (Collections.frequency(numbers,numbers.get(i)) != 1) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되지 않아야 합니다.");
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i)< 1 || numbers.get(i)> 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}