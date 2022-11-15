package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

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
        } else if (isLottoNumbersRange(numbers, LOTTO_SIZE)) {
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
        } else if (isLottoNumbersRange(winningNumbers, LOTTO_SIZE + BONUS_SIZE)) {
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
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }

    public List<Integer> getLottoNumber() {
        return this.numbers;
    }

    public static List<Integer> generateLottoTicket() {
        List<Integer> lottoTicket = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        Collections.shuffle(lottoTicket);
        return lottoTicket.stream().sorted().collect(Collectors.toList());
    }

    public int compareWinningNumbers(Lotto winningNumbers) {
        return (int) this.numbers.stream().filter(winningNumbers.getLottoNumber()::contains).count();
    }

    public boolean compareBonusNumber(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.getLottoNumber());
    }

    public Rank matchRank(Lotto winningNumbers, LottoNumber bonusNumber) {
        int matchCount = compareWinningNumbers(winningNumbers);
        boolean hasBonusHit = compareBonusNumber(bonusNumber);
        return Rank.of(matchCount, hasBonusHit);
    }
}
