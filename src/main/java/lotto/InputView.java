package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

import java.util.List;

public class InputView {

    private ConversionUtility conversionUtility = new ConversionUtility();

    public int inputMoney() {
        System.out.println(InputMessage.MONEY_INPUT_MESSAGE.getMessage());
        int purchasingAmount = Integer.parseInt(Console.readLine());
        System.out.println();

        return purchasingAmount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = conversionUtility.convertStringWinningNumbersToList(inputWinningNumbers);
        System.out.println();

        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        return bonusNumber;
    }
}
