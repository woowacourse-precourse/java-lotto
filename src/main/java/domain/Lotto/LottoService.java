package domain.Lotto;

import domain.Lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    public Lotto createWinningNumber(String winningNumber) {
        List<Integer> numbers = Stream.of(winningNumber.split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
