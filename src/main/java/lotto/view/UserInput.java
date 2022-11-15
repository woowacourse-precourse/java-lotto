package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserInputValidation;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static final String DELIMITER = ",";
    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY = "";
    private static final int WINNING_NUMBER_COUNT = 6;
    private UserInputValidation userInputValidation;

    public UserInput() {
        this.userInputValidation = new UserInputValidation();
    }

    public String getInputAmount() {
        String inputAmount = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        this.userInputValidation.checkWhiteSpace(inputAmount);
        this.userInputValidation.checkIsNumber(inputAmount);
        return inputAmount;
    }

    public int getBuyAmount(String inputAmount) {
        int buyAmount = Integer.parseInt(inputAmount);
        this.userInputValidation.checkBuyLotto(buyAmount);
        return buyAmount;
    }

    public String getInputWinningNumbers() {
        String inputWinningNumbers = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        this.userInputValidation.checkCorrectCount(inputWinningNumbers);
        return inputWinningNumbers;
    }

    public List<Integer> makeWinningNumbers(String userInput) {
        String[] userInputs = userInput.split(DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>(WINNING_NUMBER_COUNT);
        for (String number : userInputs) {
            this.userInputValidation.checkWhiteSpace(number);
            this.userInputValidation.checkIsNumber(number);
            winningNumbers.add(Integer.parseInt(number));
        }

        for (Integer winningNumber : winningNumbers) {
            this.userInputValidation.checkInvalidNumber(winningNumber.intValue());
        }
        return winningNumbers;
    }

    public String getInputBonusNumber() {
        String inputBonusNumber = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        this.userInputValidation.checkWhiteSpace(inputBonusNumber);
        this.userInputValidation.checkIsNumber(inputBonusNumber);
        return inputBonusNumber;
    }

    public int getBonusNumber(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        this.userInputValidation.checkInvalidNumber(bonusNumber);
        return bonusNumber;
    }
}
