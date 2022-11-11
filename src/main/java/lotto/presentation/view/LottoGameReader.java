package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.presentation.view.converter.ReaderConverter;
import lotto.presentation.view.validate.LottoReaderValidator;

public class LottoGameReader {

    public static Integer readLottoAmount() {
        LottoGamePrinter.printEnterLottoAmount();
        String lottoAmount = readLine();
        LottoReaderValidator.validateNumber(lottoAmount);
        return ReaderConverter.convertInteger(lottoAmount);
    }

    public static List<Integer> readWinNumber() {
        LottoGamePrinter.printEnterWinNumber();
        String winNumber = readLine();
        LottoReaderValidator.validateCommaSeparatorArray(winNumber);
        return ReaderConverter.convertIntegerList(winNumber);
    }

    public static Integer readBonusNumber() {
        LottoGamePrinter.printEnterBonusNumber();
        String bonusNumber = readLine();
        return ReaderConverter.convertInteger(bonusNumber);
    }

    public static String readLine() {
        return Console.readLine();
    }
}
