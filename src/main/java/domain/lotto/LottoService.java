package domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    public Lotto createLotto(String inputNumber) {
        List<Integer> numbers = Stream.of(inputNumber.split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
