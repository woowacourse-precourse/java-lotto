package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("보너스 번호를 제외한 로또 번호는 6개를 입력해야 합니다.");
        }
        if (numbers.stream().anyMatch(s -> s < 1 || s > 45)){
            throw new IllegalArgumentException("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
        }
        if (numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}