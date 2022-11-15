package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.presentation.view.converter.ReaderConverter;
import lotto.presentation.view.validate.LottoReaderValidator;

public class LottoGameReader {

    private final LottoGamePrinter lottoGamePrinter;

    public LottoGameReader(LottoGamePrinter lottoGamePrinter) {
        this.lottoGamePrinter = lottoGamePrinter;
    }

    public Integer readLottoAmount() {
        lottoGamePrinter.printEnterLottoAmount();
        String lottoAmount = readLine();
        LottoReaderValidator.validateNumber(lottoAmount);
        return ReaderConverter.convertInteger(lottoAmount);
    }

    public List<Integer> readGeneralWinNumbers() {
        lottoGamePrinter.printEnterWinNumber();
        String winNumber = readLine();
        LottoReaderValidator.validateCommaSeparatorArray(winNumber);
        return ReaderConverter.convertIntegerList(winNumber);
    }

    public Integer readBonusNumber() {
        lottoGamePrinter.printEnterBonusNumber();
        String bonusNumber = readLine();
        LottoReaderValidator.validateNumber(bonusNumber);
        return ReaderConverter.convertInteger(bonusNumber);
    }

    public String readLine() {
        return Console.readLine();
    }
}
