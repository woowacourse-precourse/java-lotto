package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String INPUT_NUMBER_MESSAGE = "구입금액을 입력해 주세요.";


    public Lotto(List<Integer> numbers) {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(numbers);

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static String UserInput() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
