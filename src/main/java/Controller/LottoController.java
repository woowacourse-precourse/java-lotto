package Controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static Utils.Exceptions.EXCEPTIONS;
import static Views.InputView.INPUT_VIEW;
import static Views.OutputView.OUTPUT_VIEW;

public class LottoController {
    public static final LottoController LOTTO_CONTROLLER = new LottoController();

    public List<List<String>> CompareWinningNumbersWithBonusNumbers() {
        List<List<String>> winningNumbers = new ArrayList<>();
        OUTPUT_VIEW.PrintInputWinningNumbers();
        winningNumbers.add(INPUT_VIEW.InputWinningNumbers(Console.readLine()));
        OUTPUT_VIEW.PrintInputBonusNumber();
        winningNumbers.add(INPUT_VIEW.InputBonusNumber(Console.readLine()));
        EXCEPTIONS.ValidateNumbersDuplication(winningNumbers);
        return winningNumbers;
    }
}
