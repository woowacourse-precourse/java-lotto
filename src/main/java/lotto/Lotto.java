package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_MIN_NUMBER = 1;
    private final List<Integer> numbers;

    private PrizeDetails priceDetails;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
        validateOverRangeNumber(numbers);
        this.numbers = numbers;
        this.priceDetails = PrizeDetails.NOT_THING;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (isListSizeIsSix(numbers)) {
            throw new IllegalArgumentException("숫자 여섯개를 입력해주세요");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("숫자 입력을 중복으로 하지 말아주세요");
        }
    }

    private void validateOverRangeNumber(List<Integer> numbers) {
        if (isListSizeIsSix(numbers) || hasDuplicatedNumber(numbers) || hasOverRangeNumber(numbers)) {
            throw new IllegalArgumentException(String.format("수의 범위는 %d~%d까지 입니다.", LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }


    // TODO: 추가 기능 구현

    private boolean hasOverRangeNumber(List<Integer> numbers) {
        return numbers.stream().filter(i -> i < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < i).count() != 0;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isListSizeIsSix(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }


    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public void setPriceDetails(PrizeDetails priceDetails) {
        this.priceDetails = priceDetails;
    }

    public PrizeDetails getPriceDetails() {
        return priceDetails;
    }
}
