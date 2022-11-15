package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Lotto {
    private final List<LottoNum> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNum::new).collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자개수가 잘못됨");
        }
    }

    public List<LottoNum> getNumbers() {
        return (numbers);
    }







    // TODO: 추가 기능 구현
}
