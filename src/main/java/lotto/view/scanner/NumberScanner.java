package lotto.view.scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class NumberScanner {
    public String inputPayment() {
        String won = readLine();
        validateParseInt(won);
        return won;
    }

    private void validateParseInt(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
