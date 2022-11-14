package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_START_NUMBER = 1; // 로또 시작 번호
    public static final int LOTTO_END_NUMBER = 45; // 로또 끝 번호
    public static final int LOTTO_SIZE = 6; // 로또 한세트의 번호수
    private final List<Integer> numbers;

    /**
     * Lotto 생성자
     *
     * @param numbers Integer로 된 로또 번호 리스트
     * @throws IllegalArgumentException 숫자의 범위나 개수가 유효하지 않거나 중복되는 숫자가 있을 경우
     */
    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 유효하지 않은 로또 번호가 들어올 경우 예외 발생
     *
     * @param numbers 검사할 로또 번호 List
     * @throws IllegalArgumentException 숫자의 범위나 개수가 유효하지 않거나 중복되는 숫자가 있을 경우
     */
    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(lotto.domain.LottoErrorCode.INVALID_LOTTO_SIZE.toString());
        }

        if (new HashSet<Integer>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(lotto.domain.LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
        }

        for (Integer number : numbers) {
            if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(lotto.domain.LottoErrorCode.INVALID_LOTTO_RANGE.toString());
            }
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }
}