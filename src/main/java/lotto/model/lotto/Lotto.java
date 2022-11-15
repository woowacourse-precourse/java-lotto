package lotto.model.lotto;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<LottoNumber> numbers;

    Lotto(List<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    public Lotto(Lotto oth) {
        this.numbers = new ArrayList<>(oth.numbers);
    }

    public LottoNumber getNumber(int idx) {
        return numbers.get(idx);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if(doesNotHaveRightLength(numbers)) {
            throw new IllegalArgumentException("로또 번호는 " + Lotto.LOTTO_NUMBER_LENGTH + "개여야 합니다.");
        }
        if(haveDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호가 중복되어서는 안 됩니다.");
        }
    }

    private boolean doesNotHaveRightLength(List<LottoNumber> numbers) {
        return numbers.size() != Lotto.LOTTO_NUMBER_LENGTH;
    }

    private boolean haveDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> tmpSet = new HashSet<>();

        for (LottoNumber number : numbers) {
            if (!tmpSet.add(number)) {
                return true;
            }
        }
        return false;
    }
}
