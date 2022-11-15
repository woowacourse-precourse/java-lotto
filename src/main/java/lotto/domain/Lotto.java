package lotto.domain;

import java.util.Collections;
import java.util.List;


public class Lotto {
    private static final String ERROR_INPUT_NUMBER = "[ERROR]로또 개수는 6개 입니다.";
    private static final String ERROR_OVERLAP_NUMBER = "[ERROR]또 숫자가 중복되었습니다.";

    private static final int COUNT_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (!isOverLapNumber(numbers)) {
            System.out.println(ERROR_OVERLAP_NUMBER);
            throw new IllegalArgumentException(ERROR_OVERLAP_NUMBER);
        }
        if (!isCorrectSize(numbers)) {
            System.out.println(ERROR_INPUT_NUMBER);
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
        }
    }
    // TODO: 추가 기능 구현
    public static boolean isOverLapNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int numberCount = Collections.frequency(numbers, numbers.get(i));
            if (numberCount > COUNT_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            return false;
        }
        return true;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}

