package lotto.dto;

import java.util.List;

public class WinningLottoNumberDto {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLottoNumberDto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoNumberDto createWinningLottoNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLottoNumberDto(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
