package lotto.domain;

import static lotto.domain.NumberParser.numbers;

import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.WinningNumber;
import lotto.domain.winning.WinningNumbers;

public class LottoMachine {
    // WinningNumbers를 만들어야지
    public WinningNumbers winningNumbers(String formattedNumber, String strBonusNumber) {
        WinningNumber winningNumber = new WinningNumber(numbers(formattedNumber));
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(strBonusNumber));
        return new WinningNumbers(winningNumber, bonusNumber);
    }
}
