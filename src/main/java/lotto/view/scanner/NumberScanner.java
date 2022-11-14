package lotto.view.scanner;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class NumberScanner {
    private static final String DELIMITER = ",";

    public String inputPayment() {
        String won = readLine();
        validateParseInt(won);
        return won;
    }

    public List<Integer> inputWinningLottoNumbers() {
        String[] winningLottoNumberSplitBy = splitByDelimiter(readLine());
        return Collections.emptyList();
    }

    private String[] splitByDelimiter(String winningLottoNumbers) {
        return winningLottoNumbers.split(DELIMITER);
    }

    private void validateParseInt(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
