package lotto.service;

import lotto.domain.WinningLottoNumbers;
import lotto.exception.BonusNumberException;
import lotto.view.InputOutputView;

import java.util.List;

public class ProduceWinningNumbers {
    private String getWinningNumbers;
    private int bonusNumber;

    private InputOutputView inputOutputView = new InputOutputView();
    private WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();
    private BonusNumberException bonusNumberException = new BonusNumberException();

    public List<Integer> getWinningNumbers() {
        getWinningNumbers = inputOutputView.getWinningNumbers();
        return winningLottoNumbers.getWinningLottoNumbers(getWinningNumbers);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String input = inputOutputView.getBonusNumber();
        bonusNumberException.fullException(input);
        bonusNumber = Integer.parseInt(input);
        return winningLottoNumbers.getBonusNumber(winningNumbers, bonusNumber);
    }
}
