package utils;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    private static final Pattern REGEX = Pattern.compile("[0-9]+");

    public static void checkLottoPurchaseAmountIsValid(String userInput) {
        if (!userInput.matches(REGEX.pattern())) {
            throw new IllegalArgumentException(UIConstants.INVALID_PURCHASE_AMOUNT);
        }

        int purchaseAmount = Integer.parseInt(userInput);
        if (purchaseAmount <= 0 ||
                purchaseAmount % LottoConstants.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(UIConstants.INVALID_PURCHASE_AMOUNT);
        }
    }

    public static void checkWinsNumberIsValid(String userInput) {
        String[] tokens = userInput.split(LottoConstants.SEPARATOR);

        if (tokens.length != LottoConstants.LOTTO_NUM) {
            throw new IllegalArgumentException(UIConstants.INVALID_WIN_NUMBERS_COUNT);
        }

        for (String token : tokens) {
            if (!token.matches(REGEX.pattern())) {
                throw new IllegalArgumentException(UIConstants.INVALID_WIN_INPUT_FORMAT);
            }
            int number = Integer.parseInt(token);
            if (number < LottoConstants.MIN_LOTTO_VALUE ||
                    number > LottoConstants.MAX_LOTTO_VALUE) {
                throw new IllegalArgumentException(UIConstants.INVALID_RANGE_WIN_NUMBERS);
            }
        }

        int noDuplicatedSize = Arrays.stream(tokens).collect(Collectors.toSet()).size();
        if (noDuplicatedSize != LottoConstants.LOTTO_NUM) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_WIN_NUMBERS);
        }
    }

    public static void checkBonusNumberIsValid(String userInput, List<Integer> winNumbers) {
        if (!userInput.matches(REGEX.pattern())) {
            throw new IllegalArgumentException(UIConstants.INVALID_BONUS_INPUT_FORMAT);
        }

        int bonusNumber = Integer.parseInt(userInput);
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_BONUS_NUMBER);
        }

        if (bonusNumber < LottoConstants.MIN_LOTTO_VALUE ||
                bonusNumber > LottoConstants.MAX_LOTTO_VALUE) {
            throw new IllegalArgumentException(UIConstants.INVALID_RANGE_BONUS_NUMBER);
        }
    }
}
