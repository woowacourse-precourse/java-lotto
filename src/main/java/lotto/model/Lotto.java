package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String COMMA = ",";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().map(LottoNumber::of).collect(Collectors.toList());
    }

    public Lotto(String numbers) {
        this(mapToInteger(numbers));
    }

    private static List<Integer> mapToInteger(String numbers) {
        return Arrays.stream(numbers.split(COMMA)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException("서로 다른 6개의 수를 입력해주세요.");
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == LOTTO_SIZE;
    }

    public int countMatchNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(this.numbers::contains).count();
    }

    public boolean isMatch(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getIntegerNumbers() {
        return numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
