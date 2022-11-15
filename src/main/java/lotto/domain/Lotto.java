package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final static int TWO_LOTTERIES = 12;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자의 개수는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }

        numbers.forEach(this::validateLottoNumberRange);
    }

    public void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이 숫자만 로또 번호가 될 수 있습니다.");
        }
    }

    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public int getMatchCountWith(Lotto lotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(lotto.numbers);
        uniqueNumbers.addAll(this.numbers);

        return TWO_LOTTERIES - uniqueNumbers.size();
    }

    public boolean contain(int number) {
        return this.numbers.contains(number);
    }
}
