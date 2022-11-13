package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int STATIC_LOTTO_NUMBERS_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static Lotto newLotto() {
        return new Lotto(randomLottoNumbers());
    }

    private static List<Integer> randomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        while (lottoNumbers.size() < STATIC_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(RandomNum(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
        return lottoNumbers;
    }

    public static int RandomNum(final int startNum, final int endNum) {
        Random RANDOM = new Random();
        if (startNum < 0) {
            throw new IllegalArgumentException();
        }
        if (startNum > endNum) {
            throw new IllegalArgumentException();
        }
        if (startNum == endNum) {
            return startNum;
        }
        return startNum + RANDOM.nextInt(endNum - startNum + 1);
    }

}
