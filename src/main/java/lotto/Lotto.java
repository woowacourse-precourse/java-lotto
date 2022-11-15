package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final int vic_number = 6; // 뽑는 갯수 및 당첨 갯수 확인
    private static final int vic_bonus_number = 1; // 뽑는 갯수 및 당첨 갯수 확인

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
        repeated(numbers);
        Over(numbers);
    }
    // 6자리 아닌 값 확인
    private void validate(List<Integer> numbers) {
        if (numbers.size() != vic_number) {
            throw new IllegalArgumentException("[ERROR]" + vic_number  +" 자리 숫자를 입력해주세요");
        }
    }
    // 중복된 숫자 확인
    private void repeated(List<Integer> numbers) {
        HashSet<Integer> check_repeat = new HashSet<>(numbers);
        if (numbers.size() != check_repeat.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
    private void Over(List<Integer> numbers){
        List<Integer> new_numbers = numbers.stream().filter(t-> t > 45 || t < 0).collect(Collectors.toList());
        if(new_numbers.size() > 0){
            throw new IllegalArgumentException("[ERROR] 0이상 45이하의 숫자를 입력하세요.");
        }
    }
}
