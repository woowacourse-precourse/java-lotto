package lotto;

import java.util.List;

public class Lotto{
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationCheck(numbers);
        this.numbers = numbers;
    }

    // 로또 당첨 번호의 길이가 6을 넘는지 확인한다.
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 길이가 6을 넘습니다.");
        }
    }

    // 중복 수가 있는지 체크한다.
    private void duplicationCheck(List<Integer> numbers){
        for (Integer number:numbers) {
            if(numbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복 수가 존재합니다.");
            }
        }
    }
}
