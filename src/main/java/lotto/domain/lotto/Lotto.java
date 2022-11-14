package lotto.domain.lotto;

import static lotto.message.LottoLine.LOTTO_LINE_END;
import static lotto.message.LottoLine.LOTTO_LINE_START;
import static lotto.message.LottoLine.LOTTO_NUMBER_SEPARATOR;
import static lotto.validation.LottoNumberValidation.validateDuplicate;
import static lotto.validation.LottoNumberValidation.validateNumbersRange;
import static lotto.validation.LottoNumberValidation.validateSize;
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
        stringBuffer.append(LOTTO_LINE_START.getValue());

        for (int i = 0; i < sorted.size(); i++) {
            stringBuffer.append(sorted.get(i));
            if (i != sorted.size() - 1) {
                stringBuffer.append(LOTTO_NUMBER_SEPARATOR.getValue());
            }
        }

        stringBuffer.append(LOTTO_LINE_END.getValue());
        return stringBuffer.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumbersRange(numbers);
    }

}