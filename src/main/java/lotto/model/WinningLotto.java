package lotto.model;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private final Set<LottoNumber> numbers;

    public WinningLotto(String lotto) {
        numbers = toLottoNumbers(lotto);
    }

    public Set<LottoNumber> toLottoNumbers(String lotto) {
        return Stream.of(lotto.split(","))
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Lotto toLotto() {
        return new Lotto(numbers);
    }
}