package lotto.domain;

import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;
import lotto.domain.winning.WinningLotto;

public class LottoMachine {

    private final WinningNumberParser winningNumberParser;

    public LottoMachine(WinningNumberParser winningNumberParser) {
        this.winningNumberParser = winningNumberParser;
    }

    public WinningLotto winningLotto(String formattedNumber, String strBonusNumber) {
        Lotto winningNumber = new Lotto(
                winningNumberParser.winningNumbers(formattedNumber)
        );
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(strBonusNumber));
        
        return new WinningLotto(winningNumber, bonusNumber);
    }
}
