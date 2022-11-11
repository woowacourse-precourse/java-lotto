package lotto.domain;

import lotto.utils.Lotto;
import lotto.exception.LottoNumberException;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    LottoNumberException lottoNumberException = new LottoNumberException();

    /**
     * 당첨 번호를 입력 받으며 쉼표(,)를 기준으로 구분
     */
    public List<Integer> getWinningLottoNumbers(String inputNumbers) {
        String[] splitInputNumbers = (inputNumbers.split(","));
        List<Integer> winningNumbers = new ArrayList<>();

        for (int idx = 0; idx < splitInputNumbers.length; idx++) {
            winningNumbers.add
                    (Integer.parseInt(splitInputNumbers[idx]));
        }

        Lotto lotto = new Lotto(winningNumbers);

        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        lottoNumberException.bonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
