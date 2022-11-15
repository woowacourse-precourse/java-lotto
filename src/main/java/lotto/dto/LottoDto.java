package lotto.dto;

import java.util.List;

public class LottoDto {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoDto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
