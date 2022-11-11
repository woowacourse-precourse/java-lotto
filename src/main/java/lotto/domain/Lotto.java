package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호의 갯수는 6개로 이루어져야만 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 중첩될수 없습니다.");
        }
        for (Integer number : numbers) {
            if (number > MAX || number < MIN) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 45보다 크거나 1보다 작을수 없습니다.");
            }
        }
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
