package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!isInBound(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 잘못되었습니다.");
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> ascending(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>(numbers);
        Collections.sort(copy);
        return Collections.unmodifiableList(copy);
    }


    private boolean isInBound(List<Integer> numbers) {
        return numbers.size() == Config.LOTTO_NUMBER_COUNT;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != Config.LOTTO_NUMBER_COUNT;
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }

    public LottoRank findLottoRank(Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) winningLotto.numbers.stream()
                .filter(this::contain)
                .count();
        return LottoRank.getRank(matchCount, this.contain(bonusNumber));
    }

    public List<Integer> getNumbers() {
        return numbers;
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
        return this.numbers.containsAll(lotto.numbers);
    }
}
