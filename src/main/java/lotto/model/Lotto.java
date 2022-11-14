package lotto.model;

import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public static final String LOTTO_DELIMITER = ",";
    public static final int LOTTO_ONE_PRICE = 1000;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_FIRST_REWARD = 2000000000;
    public static final int LOTTO_SECOND_REWARD = 30000000;
    public static final int LOTTO_THIRD_REWARD = 15000000;
    public static final int LOTTO_FOURTH_REWARD = 50000;
    public static final int LOTTO_FIFTH_REWARD = 5000;
    public static final int LOTTO_LOSE_REWARD = 0;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    private final String INVALID_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되지 않은 1부터 45 사이의 숫자 6개입니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        try {
            Set<Integer> numberSet = makeNumberSet(numbers);
            if (numbers.size() != LOTTO_LENGTH || numberSet.size() != LOTTO_LENGTH) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            LottoService.status = LottoService.ERROR_STATUS;
            OutputView.printError(INVALID_LOTTO_NUMBER_ERROR);
        }
    }

    private Set<Integer> makeNumberSet(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (!(number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX)) {
                throw new IllegalArgumentException();
            }
            numberSet.add(number);
        }
        return numberSet;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
