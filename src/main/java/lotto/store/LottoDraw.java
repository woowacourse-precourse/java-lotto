package lotto.store;

import lotto.enumeration.LottoErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoDraw {
    private static LottoDraw lottoDraw;

    private LottoDraw() {
    }

    public static LottoDraw getInstance() {
        if (lottoDraw == null) {
            lottoDraw = new LottoDraw();
        }
        return lottoDraw;
    }

    public List<Integer> pickWinNumbers(String readline) {
        validateComma(readline);
        validateNumeric(readline.split(","));
        List<Integer> winNumbers = changeStringToInt(readline);
        validateDuplication(winNumbers);
        validateRange(winNumbers);
        return winNumbers;
    }

    public int pickBonusNumber(String readline) {
        validateNumeric(new String[]{readline});
        int bonusNumber = Integer.parseInt(readline);
        validateRange(List.of(bonusNumber));
        return bonusNumber;
    }

    private List<Integer> changeStringToInt(String readline) {
        int[] changeInteger = Arrays.stream(readline.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(changeInteger).boxed().collect(Collectors.toList());
    }

    private void validateComma(String readline) {
        if (readline.split(",").length != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.COMMA_ERROR.getErrorMessage());
        }
    }

    private void validateNumeric(String[] readline) {
        if (!Pattern.matches("^\\d*$", String.join("", readline))) {
            throw new IllegalArgumentException(LottoErrorMessage.NUMERIC_ERROR.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> winNumbers) {
        if (new HashSet<>(winNumbers).size() != winNumbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATION_ERROR.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> winNumbers) {
        if (winNumbers.stream().anyMatch(winNumber -> winNumber < 1 || winNumber > 45)) {
            throw new IllegalArgumentException(LottoErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

}
