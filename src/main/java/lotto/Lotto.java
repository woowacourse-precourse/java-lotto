package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {//예외처리 및 통합구간 why? Lotto의 매개변수로 number을 받아와야 하는게 선제되니까
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numberValidate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void numberValidate(List<Integer> numbers) {
        Collections.sort(new ArrayList<>(numbers));
        if(numbers.get(0)<1){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상의 숫자여야 합니다.");
        } else if (numbers.get(numbers.size()-1)>45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {

        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }

    }
}
