package lotto.domain;

import static lotto.domain.NumberParser.numbers;

import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;
import lotto.domain.winning.WinningLotto;

public class LottoMachine {

    public WinningLotto winningLotto(String formattedNumber, String strBonusNumber) {
        Lotto winningNumber = new Lotto(numbers(formattedNumber));
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(strBonusNumber));
        
        return new WinningLotto(winningNumber, bonusNumber);
    }
}
