package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import static lotto.constValue.Constants.ExceptionMessage.LOTTO_WINNING_NUMBER_BAD_FORMAT_ERROR_MESSAGE;
import static lotto.constValue.Constants.ExceptionMessage.LOTTO_WINNING_NUMBER_OVER_RANGE_ERROR_MESSAGE;

public class Winner {

    private final List<Integer> lottoWinningNumber;

    public Winner(String lottoWinningNumber) {
        validateLottoWinningNumber(lottoWinningNumber);
        this.lottoWinningNumber = getLottoWinningNumberParsing(lottoWinningNumber);
    }

    public List<Integer> getLottoWinningNumber() {
        return lottoWinningNumber;
    }

    public List<Integer> getLottoWinningNumberParsing(String lottoNumber) {
        List<Integer> lottoWinningNumber = new ArrayList<>();
        String[] lottoNumbersOnly = lottoNumber.split(",");
        for (String lottoNumberOnly : lottoNumbersOnly) {
            int lottoNumberParsing = Integer.parseInt(lottoNumberOnly);
            lottoWinningNumber.add(lottoNumberParsing);
        }
        return lottoWinningNumber;
    }

    public void validateLottoWinningNumber(String lottoNumber) {
        validateLottoWinningNumberFormat(lottoNumber);
        validateLottoWinningNumberRange(lottoNumber);
    }


    private static void validateLottoWinningNumberRange(String lottoNumber) {
        String[] lottoNumbersOnly = lottoNumber.split(",");
        for (String lottoNumberOnly : lottoNumbersOnly) {
            int lottoNumberParsing = Integer.parseInt(lottoNumberOnly);
            throwLottoWinningNumberException(lottoNumberParsing);
        }
    }

    private static void throwLottoWinningNumberException(int lottoNumberParsing) {
        if (lottoNumberParsing >= 1 && lottoNumberParsing <= 45) {
            return;
        }
        throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_OVER_RANGE_ERROR_MESSAGE);
    }

    private static void validateLottoWinningNumberFormat(String lottoNumber) {
        if (isLottoNumberFormat(lottoNumber)) {
            return;
        }
        throw new IllegalArgumentException(LOTTO_WINNING_NUMBER_BAD_FORMAT_ERROR_MESSAGE);
    }

    private static boolean isLottoNumberFormat(String lottoNumber) {
        boolean found = false;

        String regex = "^[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}" +
                ",[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lottoNumber);
        if (matcher.matches()) {
            found = true;
        }
        return found;
    }
}
