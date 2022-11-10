package lotto.data.dto;

import java.util.List;
import java.util.Set;

public class LottoAnswerDto {

    private final Set<Integer> numbers;
    private final int bonusNumber;

    LottoAnswerDto(List<Integer> numbers, int bonusNumber){
        this.numbers = Set.copyOf(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
