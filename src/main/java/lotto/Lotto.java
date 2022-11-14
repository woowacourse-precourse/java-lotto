package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException(LottoErrorMessages.INVALID_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean[] used = new boolean[46];
        for (int n : numbers) {
            if (used[n]) {
                throw new IllegalArgumentException(LottoErrorMessages.HAVE_DUPLICATION.getMessage());
            }
            used[n] = true;
        }
    }

    enum LottoErrorMessages {
        INVALID_SIZE("로또 번호는 6개의 숫자로 구성되어야 합니다."),
        INVALID_RANGE("번호들은 1 ~ 45 범위의 정수여야 합니다."),
        HAVE_DUPLICATION("중복되지 않은 숫자들로 구성되어야 합니다.");


        private final String message;

        LottoErrorMessages(String msg) {
            this.message = msg;
        }

        String getMessage() {
            return this.message;
        }
    }

}