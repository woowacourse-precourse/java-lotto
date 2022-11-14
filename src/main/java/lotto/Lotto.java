package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
            throw new IllegalArgumentException("[ERROR]로또는 1~45사이의 숫자 6개여야 합니다.");
        }
        for (int num : numbers){
            if (num <1 || num>45){
                throw new IllegalArgumentException("[ERROR]로또는 1~45사이의 숫자 6개여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현



    

}
