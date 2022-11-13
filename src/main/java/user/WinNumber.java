package user;

import constants.LottoConstants;
import constants.UIConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumber {

    private final List<Integer> winNumber;

    public WinNumber(String userInput) {
        validate(userInput);
        this.winNumber = Arrays.stream(userInput.split(LottoConstants.SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    private void validate(String userInput) {
        String[] tokens = userInput.split(LottoConstants.SEPARATOR);

        validateLottoNumber(tokens);
        validateInputFormat(tokens);
        validateInputRange(tokens);
        validateInputIsDuplicated(tokens);
    }

    private static void validateInputIsDuplicated(String[] tokens) {
        int noDuplicatedSize = Arrays.stream(tokens).collect(Collectors.toSet()).size();
        if (noDuplicatedSize != LottoConstants.LOTTO_NUM) {
            throw new IllegalArgumentException(UIConstants.DUPLICATED_WIN_NUMBERS);
        }
    }

    private static void validateLottoNumber(String[] tokens) {
        if (tokens.length != LottoConstants.LOTTO_NUM) {
            throw new IllegalArgumentException(UIConstants.INVALID_WIN_NUMBERS_COUNT);
        }
    }

    private void validateInputFormat(String[] tokens) {
        for (String token : tokens) {
            if (!token.matches(LottoConstants.REGEX.pattern())) {
                throw new IllegalArgumentException(UIConstants.INVALID_WIN_INPUT_FORMAT);
            }
        }
    }

    private void validateInputRange(String[] tokens) {
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < LottoConstants.MIN_LOTTO_VALUE ||
                    number > LottoConstants.MAX_LOTTO_VALUE) {
                throw new IllegalArgumentException(UIConstants.INVALID_RANGE_WIN_NUMBERS);
            }
        }
    }
}
