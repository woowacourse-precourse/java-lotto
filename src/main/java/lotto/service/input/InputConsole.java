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

    public static LottoNumbers readCorrectNumbers() {
        String readLine = Console.readLine();
        String[] splitedReadlines = readLine.split(",");

        List<LottoNumber> tempCorrectLottoNumbers = new ArrayList<>();

        for (String splitedReadline : splitedReadlines) {
            tempCorrectLottoNumbers.add(new LottoNumber(Transfer.toInteger(splitedReadline)));
        }

        return new LottoNumbers(tempCorrectLottoNumbers);
    }

    public static LottoNumber readBonusNumber() {
        String readLine = Console.readLine();
        return new LottoNumber(Transfer.toInteger(readLine));
    }

}
