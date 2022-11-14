package lotto.service.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.service.input.util.Transfer;

import java.util.ArrayList;
import java.util.List;

public class InputConsole {
    public static Money readMoney() {
        String readLine = Console.readLine();
        return new Money(Transfer.toInteger(readLine));
    }

}
