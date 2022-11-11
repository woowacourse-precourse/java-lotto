package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.presentation.view.converter.ReaderConverter;

public class LottoGameReader {

    public static Integer readLottoAmount() {
        LottoGamePrinter.printLottoAmount();
        String lottoAmount = readLine();
        return ReaderConverter.convertInteger(lottoAmount);
    }

    public static String readLine() {
        return Console.readLine();
    }
}
