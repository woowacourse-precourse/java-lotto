package lotto.domain;

import static lotto.util.Util.verifyRangeOfLottoNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // private 변경 불가
    // Lotto에 필드(인스턴스 변수)를 추가할 수 없다.

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 입력해 주세요.");
        }
        for (Integer winningNumber : numbers) {
            verifyRangeOfLottoNumber(winningNumber);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 입력하신 당첨번호 내에 중복되는 숫자가 존재합니다.");
        }
    }

    public List<Integer> get() {
        return numbers;
    }

}
