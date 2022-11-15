package utils;

import model.Errors;
import model.Game;
import model.Lotto;

import java.util.List;
import java.util.regex.Pattern;

public class UserInputValidator {
    private static Game game;

    public UserInputValidator(Game game) {
        this.game = game;
    }

    public static void validateInputIsNum(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(Errors.NUMBER.getErrorMsg());
        }
    }

    public static void validateInputMoney(String userInput) {
        int userInputMoney = Integer.parseInt(userInput);

        if (userInputMoney % 1000 != 0) {
            throw new IllegalArgumentException(Errors.MONEY.getErrorMsg());
        }
    }

    public static void validateInputLottoNumbers(String userInput) {
        final String lottoRegex = "^([1-9]?[0-9]\\,){1,5}([1-9]?[0-9])$";

        if (!Pattern.matches(lottoRegex, userInput)) {
            throw new IllegalArgumentException(Errors.LOTTO_NUMBER_FORMAT.getErrorMsg());
        }
    }

    public static void validateDuplicateBonusNumber(String userInput) {
        int userInputBonusNumber = Integer.parseInt(userInput);
        Lotto lotto = game.getLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber == userInputBonusNumber) {
                throw new IllegalArgumentException(Errors.DUPLICATE_BONUS_NUMBER.getErrorMsg());
            }
        }
    }

    public static void validateNumberRange(String userInput) {
        int userInputNumber = Integer.parseInt(userInput);

        if (userInputNumber < 1 || userInputNumber > 45) {
            throw new IllegalArgumentException(Errors.NUMBER_RANGE.getErrorMsg());
        }
    }
}
