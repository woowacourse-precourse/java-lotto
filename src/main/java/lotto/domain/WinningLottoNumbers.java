package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.exception.LottoNumberException;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class WinningLottoNumbers {
    LottoNumberException lottoNumberException = new LottoNumberException();

    /**
     * 당첨 번호를 입력 받으며 쉼표(,)를 기준으로 구분
     */
    public List<Integer> getWinningLottoNumbers() {
        String inputNumbers = readLine();
        String[] splitInputNumbers = (inputNumbers.split(","));
        List<Integer> winningNumbers = new ArrayList<>();

        for (int idx = 0; idx < splitInputNumbers.length; idx++) {
            winningNumbers.add
                    (Integer.parseInt(splitInputNumbers[idx]));
        }

        Lotto lotto = new Lotto(winningNumbers);

        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(readLine());
        lottoNumberException.bonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
