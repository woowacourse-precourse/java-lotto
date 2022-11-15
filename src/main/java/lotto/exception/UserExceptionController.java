package lotto.exception;

import lotto.ui.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserExceptionController {
    private static final String ERROR = "[ERROR] ";
    private static final String NON_NUMBER_MESSAGE = "숫자를 입력해야 합니다.";
    private static final String NON_VALID_LOTTO_SIZE_LENGTH_MESSAGE = "6개의 숫자를 쉼표로 구분하여 입력해야 합니다.";
    private static final String NON_VALID_PRICE_MESSAGE = "1000의 배수를 입력해야 합니다.";
    private static final String NON_VALID_RANGE_OF_NUMBER_MESSAGE = "1~45 사이의 숫자를 입력해야 합니다.";

    public static int validatePrice(String price) {
        int parsedPrice = validateNumber(price);
        if ((parsedPrice % UserInterface.PRICE_UNIT) != 0) {
            throw new IllegalArgumentException(ERROR + NON_VALID_PRICE_MESSAGE);
        }
        return parsedPrice;
    }

    public static List<Integer> validateWinningNumbers(String winningNumbers) {
        int lottoSize = 6;
        List<String> tokens = Arrays.stream(winningNumbers.split(",")).collect(Collectors.toList());
        if (tokens.size() != lottoSize) {
            throw new IllegalArgumentException(ERROR + NON_VALID_LOTTO_SIZE_LENGTH_MESSAGE);
        }

        List<Integer> validWinningNumbers = new ArrayList<>();
        for (String token : tokens) {
            validWinningNumbers.add(validateLottoNumber(token));
        }
        return validWinningNumbers;
    }

    public static int validateLottoNumber(String number) {
        int parsedNumber = validateNumber(number);
        if (parsedNumber < 1 || parsedNumber > 45) {
            throw new IllegalArgumentException(ERROR + NON_VALID_RANGE_OF_NUMBER_MESSAGE);
        }
        return parsedNumber;
    }

    private static int validateNumber(String number) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR + NON_NUMBER_MESSAGE);
        }
        return parsedNumber;
    }
}
