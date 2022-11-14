package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbervalidate(numbers);
        execptduplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 숫자여야 합니다.");
        }
    }

    private void numbervalidate(List<Integer> numbers){
        for(int number:numbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }
    }

    private void execptduplicate(List<Integer> numbers){
        List<Integer> noduplicatenumbers = new ArrayList<>();
        noduplicatenumbers = numbers.stream().distinct().collect(Collectors.toList());
        if(noduplicatenumbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
    // TODO: 추가 기능 구현
}
