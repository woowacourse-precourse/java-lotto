package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoFactory.LOTTO_COUNT;
import static lotto.Results.DEFAULT;
import static lotto.Results.INCREASED_VALUE;

public class Lotto {

    public static final int LOTTO_NUMBER_LENGTH_ZERO = 0;
    private static final String NUMBER_SPLIT_CRITERIA = ",";

    private final List<Integer> numbers;

    public static Lotto from(String winningNumber) {
        try {
            return new Lotto(Arrays.stream(winningNumber.split(NUMBER_SPLIT_CRITERIA))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 숫자가 아닌 값이 있습니다.");
        }
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = validateLottoNumber(numbers);
    }

    public boolean isBonusNumber(LottoBonusNumber lottoBonusNumber) {
        return lottoBonusNumber.isBonusNumber(this.numbers);
    }

    public int repeatLottoNumberCheck(Lotto lottoNumber) {
        int lottoNumberMatchCount = DEFAULT;
        for (int i : lottoNumber.numbers) {
            lottoNumberMatchCount = compareLottoNumber(i, lottoNumberMatchCount);
        }
        return lottoNumberMatchCount;
    }

    private int compareLottoNumber(int i, int lottoNumberMatchCount) {
        if (this.numbers.contains(i)) {
            return lottoNumberMatchCount + INCREASED_VALUE;
        }
        return lottoNumberMatchCount;
    }

    private List<Integer> validateLottoNumber(List<Integer> numbers) {
        validateEmpty(numbers);
        validateCount(numbers);
        validateOverlap(numbers);
        validateNumberSize(numbers);
        Collections.sort(numbers);
        return numbers;
    }

    private void validateEmpty(List<Integer> numbers) {
        if (numbers.size() == LOTTO_NUMBER_LENGTH_ZERO) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 모자릅니다.");
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new LinkedHashSet<>(numbers);
        if (overlapCheck.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 중복 숫자가 있습니다.");
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LottoFactory.END_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나 너무 큽니다");
            }
            if (number < LottoFactory.START_INCLUSIVE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 범위를 벗어나 너무 작습니다");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
