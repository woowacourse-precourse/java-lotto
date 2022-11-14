package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto makeRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers.subList(0, 6));
    }

    public static boolean isRanged(int number) {
        return 1 <= number && number <= 45;
    }

    public int matchCount(Lotto otherLotto) {
        return (int) (numbers.stream().filter(otherLotto::contains).count());
    }

    public boolean isBonusNumMatch(BonusNum bonusNum) {
        return contains(bonusNum);
    }

    public boolean contains(BonusNum bonusNum) {
        return numbers.stream().anyMatch(bonusNum::isEqual);
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');

        for (int i = 0; i < sorted.size(); i++) {
            stringBuffer.append(sorted.get(i));
            if (i != sorted.size() - 1) {
                stringBuffer.append(", ");
            }
        }

        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 숫자들의 개수가 6개가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (!isOnceAppear(numbers, number)) {
                throw new IllegalArgumentException("[ERROR] 중복이 되는 숫자가 존재합니다.");
            }
        });
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (!isRanged(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자의 범위가 1 ~ 45 이내가 아닙니다.");
            }
        });
    }

    private boolean isOnceAppear(List<Integer> numbers, int number) {
        return numbers.indexOf(number) == numbers.lastIndexOf(number);
    }
}
