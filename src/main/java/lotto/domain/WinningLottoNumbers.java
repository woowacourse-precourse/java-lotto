package lotto.domain;

import lotto.utils.Lotto;
import lotto.exception.LottoNumberException;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    LottoNumberException lottoNumberException = new LottoNumberException();

    public List<Integer> getWinningLottoNumbers(String inputNumbers) {
        String[] splitInputNumbers = (inputNumbers.split(","));
        List<Integer> winningNumbers = new ArrayList<>();

        for (int idx = 0; idx < splitInputNumbers.length; idx++) {
            winningNumbers.add
                    (Integer.parseInt(splitInputNumbers[idx]
                            .replaceAll(" ", "")));
        }

        Lotto lotto = new Lotto(winningNumbers);

        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        lottoNumberException.bonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
