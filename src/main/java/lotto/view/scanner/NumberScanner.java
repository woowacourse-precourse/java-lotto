package lotto.view.scanner;

import lotto.domain.ErrorType;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static lotto.domain.ErrorType.*;

public class NumberScanner {
    private static final String DELIMITER = ",";

    public int inputPayment() {
        String won = readLine();
        validateParseInt(won, ERROR_INPUT_PAYMENT);
        return parseInt(won);
    }

    public List<Integer> inputWinningLottoNumbers() {
        String[] winningLottoNumberSplitBy = splitByDelimiter(readLine());
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String winningLottoNumber : winningLottoNumberSplitBy) {
            validateParseInt(winningLottoNumber, ERROR_INPUT_WINNING_LOTTO_NUMBERS);
            winningLottoNumbers.add(parseInt(winningLottoNumber));
        }
        return winningLottoNumbers;
    }

    private String[] splitByDelimiter(String winningLottoNumbers) {
        return winningLottoNumbers.split(DELIMITER);
    }

    public int inputBonusNumber() {
        String bonusNumber = readLine();
        validateParseInt(bonusNumber, ERROR_INPUT_BONUS_NUMBER);
        return parseInt(bonusNumber);
    }

    private void validateParseInt(String input, ErrorType errorType) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorType.getErrorMessage());
        }
    }
}
