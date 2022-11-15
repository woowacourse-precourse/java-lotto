package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.domain.exception.BonusInputException;

public class AdditionalNumber {
    public int getBonus(Lotto lottoAnswer) {
        BonusInputException exception = new BonusInputException();
        String input = Console.readLine();

        int bonusInput = Integer.parseInt(input);
        exception.bonusVerificationPreparation(lottoAnswer, bonusInput);
        return bonusInput;
    }
}