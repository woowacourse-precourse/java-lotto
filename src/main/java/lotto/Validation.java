package lotto;

import java.util.List;

public class Validation {

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개입니다.");
        }
    }
}
