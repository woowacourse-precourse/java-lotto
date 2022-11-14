package lotto.domain.lotto;

import static lotto.message.LottoLine.LOTTO_LINE_END;
import static lotto.message.LottoLine.LOTTO_LINE_START;
import static lotto.message.LottoLine.LOTTO_NUMBER_SEPARATOR;
import static lotto.value.LottoValues.LOTTO_END_NUMBER;
import static lotto.value.LottoValues.LOTTO_SIZE;
import static lotto.value.LottoValues.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto makeLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto makeRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getValue(),
                LOTTO_END_NUMBER.getValue(), LOTTO_SIZE.getValue());
        return new Lotto(numbers.subList(0, 6));
    }

    public static boolean isRanged(int number) {
        return LOTTO_START_NUMBER.getValue() <= number && number <= LOTTO_END_NUMBER.getValue();
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
        stringBuffer.append(LOTTO_LINE_START);

        for (int i = 0; i < sorted.size(); i++) {
            stringBuffer.append(sorted.get(i));
            if (i != sorted.size() - 1) {
                stringBuffer.append(LOTTO_NUMBER_SEPARATOR);
            }
        }

        stringBuffer.append(LOTTO_LINE_END);
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