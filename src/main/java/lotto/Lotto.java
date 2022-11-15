package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자여야 합니다.");
        }
//        if (duplicate) {
//            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자여야 합니다.");
//        }
    }

    public void printLotto() {
        System.out.print("[");
        for(int i=0; i<numbers.size(); i++) {
            int number = numbers.get(i);
            if(i == numbers.size()-1) {
                System.out.print(number + "]");
                break;
            }
            System.out.print(number + ", ");
        }
    }

}
