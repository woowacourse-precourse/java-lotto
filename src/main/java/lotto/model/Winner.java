package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import static lotto.constValue.Constants.ExceptionMessage.LOTTO_WINNING_NUMBER_BAD_FORMAT_ERROR_MESSAGE;
import static lotto.constValue.Constants.ExceptionMessage.LOTTO_WINNING_NUMBER_OVER_RANGE_ERROR_MESSAGE;
import static lotto.constValue.Constants.Format.WINNING_NUMBER_FORMAT;
import static lotto.constValue.Constants.LottoInfo.MAX_RANGE;
import static lotto.constValue.Constants.LottoInfo.MIN_RANGE;
import static lotto.constValue.Constants.WinnerInfo.SEPARATOR_COMMA;

public class Winner {

    private final List<Integer> winningNumber;

    public Winner(String winningNumber) {
        validateLottoWinningNumber(winningNumber);
        this.winningNumber = getWinningNumberParsing(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public List<Integer> getWinningNumberParsing(String winningNumber) {
        List<Integer> winningNumberGroup = new ArrayList<>();
        String[] winningNumbersOnly = winningNumber.split(SEPARATOR_COMMA);
        for (String numberOnly : winningNumbersOnly) {
            int lottoNumberParsing = Integer.parseInt(numberOnly);
            winningNumberGroup.add(lottoNumberParsing);
        }
        return winningNumberGroup;
    }

    public void validateLottoWinningNumber(String winningNumber) {
        validateLottoWinningNumberFormat(winningNumber);
        validateLottoWinningNumberRange(winningNumber);
    }


    private static void validateLottoWinningNumberRange(String winningNumber) {
        String[] winningNumbersOnly = winningNumber.split(",");
        for (String numberOnly : winningNumbersOnly) {
            int winningNumberParsing = Integer.parseInt(numberOnly);
            throwLottoWinningNumberException(winningNumberParsing);
        }
    }

    private static void throwLottoWinningNumberException(int winningNumberParsing) {
        if (winningNumberParsing >= MIN_RANGE && winningNumberParsing <= MAX_RANGE) {
            return;
        }
        throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_OVER_RANGE_ERROR_MESSAGE);
    }

    private static void validateLottoWinningNumberFormat(String winningNumber) {
        if (isLottoNumberFormat(winningNumber)) {
            return;
        }
        throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_BAD_FORMAT_ERROR_MESSAGE);
    }

    private static boolean isLottoNumberFormat(String winningNumber) {
        boolean found = false;

        String regex = WINNING_NUMBER_FORMAT;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(winningNumber);
        if (matcher.matches()) {
            found = true;
        }
        return found;
    }
}
