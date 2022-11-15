package lotto;

import java.util.List;

public class Lotto {

    private final static int MAX_RANGE = 45;
    private final static int MIN_RANGE = 1;
    private final static int LOTTO_SIZE = 6;


    private static final String PRINT_SIZE_ERROR = "[ERROR] 로또는 숫자 6개만 입력해주세요.";
    private static final String PRINT_NUM_ERROR = "[ERROR] 숫자만 입력해주세요";
    private static final String PRINT_RANGE_ERROR = "[ERROR] 1부터 45까지만 유효한 숫자입니다.";
    private static final String PRINT_DUPLICATE_ERROR = "[ERROR] 겹치는 로또 숫자가 있습니다.";





    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(PRINT_SIZE_ERROR);

        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(PRINT_DUPLICATE_ERROR);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if(!numbers.stream().allMatch(number -> MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new IllegalArgumentException(PRINT_RANGE_ERROR);
        }
    }


        // TODO: 추가 기능 구현
}
