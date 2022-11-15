package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static int LOTTO_SIZE = 6;
    private static int BONUS_SIZE = 1;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 숫자의 길이가 6이 아닙니다.");
        } else if (isDuplicate(numbers, LOTTO_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 숫자에 중복이 있습니다.");
        } else if (isLottoNumbersRange(numbers, BONUS_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 숫자가 1-45 사이가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    public Lotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        winningNumbers.add(bonusNumber);
        validateWinningNumber(winningNumbers);
        this.numbers = winningNumbers;
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE + BONUS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호와 보너스 숫자의 길이가 7이 아닙니다.");
        } else if (isDuplicate(winningNumbers, LOTTO_SIZE + BONUS_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호와 보너스 번호에 중복이 있습니다.");
        } else if (isLottoNumbersRange(winningNumbers, BONUS_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호와 보너스 숫자가 1-45 사이가 아닙니다.");
        }
    }

    private Boolean isDuplicate(List<Integer> lottoNumbers, int lottoSize) {
        return lottoNumbers.stream().distinct().count() != lottoSize;
    }

    private Boolean isLottoNumbersRange(List<Integer> lottoNumbers, int lottoSize) {
        return lottoNumbers.stream().filter(this::isNumberRange).count() != lottoSize;
    }

    private Boolean isNumberRange(int number) {
        return number > LOTTO_MIN_NUMBER && number < LOTTO_MAX_NUMBER;
    }

    public List<Integer> getLottoNumber() {
        return this.numbers;
    }
}
