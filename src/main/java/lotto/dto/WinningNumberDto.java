package lotto.dto;

import java.util.List;

public class WinningNumberDto {
    public List<Integer> mainNumbers;
    public Integer bonusNumber;

    public WinningNumberDto(List<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

}
