package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers; //final : 상수(한 번 설정한 값을 변경할 수 없다.)

    //생성자(필드(numbers)를 초기화 하는 것)
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDouble(numbers);
        checkOverRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDouble(List<Integer> numbers){
        Set<Integer> numList = new HashSet<>(numbers);

        if (numbers.size() != numList.size()){
            throw new IllegalArgumentException();
        }
    }

    private void checkOverRange(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) > 45){
                throw new IllegalArgumentException();
            }
        }
    }
}
