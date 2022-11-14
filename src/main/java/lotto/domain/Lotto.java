package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Val_Check(numbers);
        Duplication_Check(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자기 숫자여야 합니댜.");
        }
    }

    private void Val_Check(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++){
            int val = numbers.get(i);
            if (val < 1 || val > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void Duplication_Check(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 숫자를 포함할 수 없습니다.");
    }

    public List<Integer> Get_numbers() {
        return this.numbers;
    }

    public Boolean contains(int val){
        return numbers.contains(val);
    }
    // TODO: 추가 기능 구현
}
