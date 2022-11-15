package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.exception.lotto.LottoNumberCountException;
import lotto.exception.lotto.LottoNumberDuplicatedException;
import lotto.exception.lotto.LottoNumberRangeException;

public class Lotto {

    private static final int SIZE = 6;
    private static final int MAX = 45;
    private static final int MIN = 1;
    private final List<Integer> lotto;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lotto = add(numbers);
    }

    private List<Integer> add(List<Integer> numbers) {
        List<Integer> nums = new ArrayList<>(numbers);
        Collections.sort(nums);
        return nums;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new LottoNumberCountException(numbers.size());
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new LottoNumberDuplicatedException(numbers);
        }
        for (Integer number : numbers) {
            if (number > MAX || number < MIN) {
                throw new LottoNumberRangeException(number);
            }
        }
    }

    public int getEqualCount(WinLotto winLotto) {
        return (int) lotto.stream().filter(winLotto::contains).count();
    }

    public List<Integer> get() {
        return lotto;
    }

    public boolean contains(int bonus) {
        return lotto.contains(bonus);
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
        return Objects.equals(lotto, lotto.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

}
