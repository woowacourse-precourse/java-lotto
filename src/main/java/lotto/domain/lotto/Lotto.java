package lotto.domain.lotto;

import static lotto.domain.place.PlaceCondition.findByCondition;
import static lotto.validation.LottoNumberValidation.validateDuplicate;
import static lotto.validation.LottoNumberValidation.validateNumbersRange;
import static lotto.validation.LottoNumberValidation.validateSize;
import static lotto.value.LottoLine.LOTTO_LINE_END;
import static lotto.value.LottoLine.LOTTO_LINE_START;
import static lotto.value.LottoLine.LOTTO_NUMBER_SEPARATOR;
import static lotto.value.LottoValue.LOTTO_END_NUMBER;
import static lotto.value.LottoValue.LOTTO_SIZE;
import static lotto.value.LottoValue.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.place.PlaceCondition;

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
        return makeLotto(numbers.subList(0, 6));
    }

    private static boolean isLastIndex(List<Integer> numbers, int idx) {
        return idx + 1 == numbers.size();
    }

    public PlaceCondition makeCondition(Lotto otherLotto, BonusNum bonusNum) {
        return findByCondition(matchCount(otherLotto), isBonusNumMatch(bonusNum));
    }

    private int matchCount(Lotto otherLotto) {
        return (int) (numbers.stream().filter(otherLotto::contains).count());
    }

    private boolean isBonusNumMatch(BonusNum bonusNum) {
        return contains(bonusNum);
    }

    private boolean contains(BonusNum bonusNum) {
        return numbers.stream().anyMatch(bonusNum::isEqual);
    }

    private boolean contains(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        StringBuffer stringBuffer = new StringBuffer();
        appendLottoStartLine(stringBuffer);

        appendLottoNumbers(sorted, stringBuffer);

        appendLottoEndLine(stringBuffer);
        return stringBuffer.toString();
    }

    private void appendLottoNumbers(List<Integer> numbers, StringBuffer stringBuffer) {
        for (int lottoIdx = 0; lottoIdx < numbers.size(); lottoIdx++) {
            stringBuffer.append(numbers.get(lottoIdx));
            if (!isLastIndex(numbers, lottoIdx)) {
                stringBuffer.append(LOTTO_NUMBER_SEPARATOR.getValue());
            }
        }
    }

    private void appendLottoStartLine(StringBuffer stringBuffer) {
        stringBuffer.append(LOTTO_LINE_START.getValue());
    }

    private void appendLottoEndLine(StringBuffer stringBuffer) {
        stringBuffer.append(LOTTO_LINE_END.getValue());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumbersRange(numbers);
    }

}