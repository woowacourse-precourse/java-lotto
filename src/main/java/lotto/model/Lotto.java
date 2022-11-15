package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static lotto.controller.LottoSystem.LOTTO_MIN;
import static lotto.controller.LottoSystem.LOTTO_MAX;
import static lotto.controller.LottoSystem.LOTTO_NUM_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 번호 개수가 %d개가 아닙니다.", LOTTO_NUM_COUNT));
        }

        Set<Integer> set = new HashSet<>();
        for(int number : numbers) {
            if (number < LOTTO_MIN || LOTTO_MAX < number) {
                throw new IllegalArgumentException("[ERROR] 발행된 로또에 범위를 넘어서는 숫자가 있습니다.");
            }
            if (set.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 발행된 로또에 중복 번호가 있습니다.");
            }
            set.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public MatchedResult checkPrizes(List<Integer> winningNumbers, int bonusNumber) {
        int matchNum = 0;
        boolean bonusMatched = false;
        for(int num : numbers) {
            if(winningNumbers.contains(num)) matchNum++;
            if(bonusNumber == num) {
                bonusMatched = true;
            }
        }
        return new MatchedResult(matchNum, bonusMatched);
    }
}
