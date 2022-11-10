package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Validator validator = new Validator();
    User user = new User();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 당첨 번호를 입력하는 메소드
     * 게임 횟수만큼 랜덤한 로또 번호를 출력하는 메소드
     */
}
