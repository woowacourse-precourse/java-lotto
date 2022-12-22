package Views;

import Utils.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final InputView INPUT_VIEW = new InputView();

    public int InputCash(String readLine) {
        Exceptions.ExcludeUnderThousand(readLine);
        return Integer.parseInt(readLine) / 1000;
    }

    public List<String> InputWinningNumbers(String readLine) {
        List<String> winningNumbers;
        winningNumbers = List.of(readLine.split(","));
        Exceptions.ExcludeNoLottoNumbers(winningNumbers);
        return winningNumbers;
    }

    public List<String> InputBonusNumber(String readLine) {
        List<String> bonusNumber = new ArrayList<>();
        Exceptions.ExcludeNoBonusNumber(readLine);
        bonusNumber.add(readLine);
        return bonusNumber;
    }
}
