package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import config.ErrorConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    /**
     * 1 ~ 45 범위의 중복되지 않은 6개의 수를 임의로 생성하여 반환합니다.
     * @return 6개의 수로 이루어진 Lotto 클래스
     */
    public static Lotto createRandomLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }

    /**
     * 6개의 숫자 리스트를 반환합니다.
     * 단, 무결성을 보장하기 위해서 불변 리스트로 변환하여 제공됩니다.
     * @return 불변 리스트
     */
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    /**
     * 입력된 숫자들에 대해 유효성을 검증합니다.
     * @param numbers 로또 번호
     */
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    /**
     * 로또 번호가 6개의 숫자로 구성되어 있는지 검증합니다.
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 입력된 수의 개수가 6이 아닐 때 예외 발생
     */
    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_NUMBERS_SIZE);
        }
    }

    /**
     * 각 번호들이 1 ~ 45 범위의 정수인지 검증합니다.
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 1 ~ 45 범위가 아닌 번호가 있을 경우 예외 발생
     */
    private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException(ErrorConstants.INVALID_RANGE);
            }
        }
    }

    /**
     * 각 번호들 중 중복이 있는지 검증합니다.
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 중복된 번호가 있을 경우 예외 발생
     */
    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        boolean[] used = new boolean[46];
        for (int n : numbers) {
            if (used[n]) {
                throw new IllegalArgumentException(ErrorConstants.HAVE_DUPLICATION);
            }
            used[n] = true;
        }
    }

}
