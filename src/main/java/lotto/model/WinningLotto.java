package lotto.model;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.LottoExceptionMessage;

public class WinningLotto {
    private final Set<LottoNumber> numbers;

    public WinningLotto(String lotto) {
        try {
            numbers = toLottoNumbers(lotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public Set<LottoNumber> toLottoNumbers(String lotto) {
        return Stream.of(lotto.split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Lotto toLotto() {
        return new Lotto(numbers);
    }
}