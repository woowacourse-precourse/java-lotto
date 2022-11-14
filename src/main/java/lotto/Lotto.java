package lotto;

import java.util.List;

import static Comment.ErrorMessage.*;
import static lotto.Validation.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        lengthValidation(numbers);

        overlapValidation(numbers);

        rangeValidation(numbers);
    }

    // TODO: 추가 기능 구현
    /* 리스트 불러오기 */
    public List<Integer> getNumbers() {
        return numbers;
    }

    /* 등수 확인 */
    public Rank getRank(int matchingCount, int bonusNumber) {
        if (matchingCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return Rank.valueOf(matchingCount, true);
            }
            return Rank.valueOf(matchingCount, false);
        }

        return Rank.valueOf(matchingCount, false);
    }
}
