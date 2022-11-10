package lotto.service;

import lotto.domain.WinningLottoNumbers;
import lotto.view.InputOutputView;

import java.util.List;

public class ProduceWinningNumbers {
    private String getWinningNumbers;
    private int bonusNumber;

    private InputOutputView inputOutputView = new InputOutputView();
    private WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();

    public List<Integer> getWinningNumbers() {
        getWinningNumbers = inputOutputView.getWinningNumbers();
        return winningLottoNumbers.getWinningLottoNumbers(getWinningNumbers);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        bonusNumber = inputOutputView.getBonusNumber();
        return winningLottoNumbers.getBonusNumber(winningNumbers, bonusNumber);
    }
}
