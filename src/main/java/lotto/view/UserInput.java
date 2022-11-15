package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.UserInputValidation;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static final String DELIMITER = ",";
    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY = "";
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final UserInputValidation userInputValidation = new UserInputValidation();

    public UserInput() {
    }

    public String getInputAmount() {
        String inputAmount = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        userInputValidation.checkWhiteSpace(inputAmount);
        userInputValidation.checkIsNumber(inputAmount);
        return inputAmount;
    }

    public int getBuyAmount(String inputAmount) {
        int buyAmount = Integer.parseInt(inputAmount);
        userInputValidation.checkBuyLotto(buyAmount);
        return buyAmount;
    }

    public String getInputWinningNumbers() {
        String inputWinningNumbers = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        userInputValidation.checkCorrectCount(inputWinningNumbers);
        return inputWinningNumbers;
    }

    public List<Integer> makeWinningNumbers(String userInput) {
        String[] userInputs = userInput.split(DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>(WINNING_NUMBER_COUNT);
        for (String number : userInputs) {
            userInputValidation.checkWhiteSpace(number);
            userInputValidation.checkIsNumber(number);
            winningNumbers.add(Integer.parseInt(number));
        }

        for (Integer winningNumber : winningNumbers) {
            userInputValidation.checkInvalidNumber(winningNumber);
        }
        return winningNumbers;
    }

    public String getInputBonusNumber() {
        String inputBonusNumber = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        userInputValidation.checkWhiteSpace(inputBonusNumber);
        userInputValidation.checkIsNumber(inputBonusNumber);
        return inputBonusNumber;
    }

    public int getBonusNumber(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        userInputValidation.checkInvalidNumber(bonusNumber);
        return bonusNumber;
    }
}
