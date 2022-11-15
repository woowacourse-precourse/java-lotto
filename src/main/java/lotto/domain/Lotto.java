package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

import static lotto.domain.messages.ErrorMessages.DUPLICATE_ERROR_MESSAGE;
import static lotto.domain.messages.ErrorMessages.SIZE_ERROR_MESSAGE;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);

        lottoNumbers = new LinkedList<>();

        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.generateFromRawValue(number));
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean duplicated = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (duplicated) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1
                , 45
                , 6));
    }

    public static List<Lotto> generateByAmount(Integer totalAmount) {
        List<Lotto> lottos = new LinkedList<>();

        for (int amount = 0; amount < totalAmount; amount++) {
            lottos.add(Lotto.generate());
        }

        return lottos;
    }

    public static Lotto generateFromRawValues(List<Integer> rawValues) {
        return new Lotto(rawValues);
    }

    public boolean isMatchedNumbersWith(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public int countMatchedNumbersWith(Lotto otherLotto) {
        return (int) lottoNumbers.stream().filter(otherLotto::isMatchedNumbersWith).count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
