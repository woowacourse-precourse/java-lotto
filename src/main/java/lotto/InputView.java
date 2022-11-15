package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.EtcNumber;
import lotto.enums.InputMessage;

import java.util.List;

public class InputView {

    private ConversionUtility conversionUtility = new ConversionUtility();

    public int inputMoney() {
        System.out.println(InputMessage.MONEY_INPUT_MESSAGE.getMessage());
        String inputMoney = Console.readLine();
        validateInputMoney(inputMoney);
        int purchasingAmount = Integer.parseInt(inputMoney);
        System.out.println();

        return purchasingAmount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
        String inputWinningNumbers = Console.readLine();
        validateInputWinningLotto(inputWinningNumbers);
        List<Integer> winningNumbers = conversionUtility.convertStringWinningNumbersToList(inputWinningNumbers);
        validateNumberRange(winningNumbers);
        System.out.println();

        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        String inputBonusNumber = Console.readLine();
        validateInputBonusNumber(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        System.out.println();

        return bonusNumber;
    }

    public void validateInputMoney(String inputMoney) {
        if (isNumber(inputMoney) && isBiggerThanThousand(inputMoney) && isDivideByThousand(inputMoney)) {
            return;
        }
        throw new IllegalArgumentException(InputMessage.ERROR_MESSAGE.getMessage());
    }

    public boolean isNumber(String input) {
        for (int index = EtcNumber.ZERO.getNumber(); index < input.length(); index++) {
            char number = input.charAt(index);
            if (!Character.isDigit(number)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBiggerThanThousand(String inputMoney) {
        return Integer.parseInt(inputMoney) >= 1000;
    }

    public boolean isDivideByThousand(String inputMoney) {

        if (Integer.parseInt(inputMoney) % 1000 == 0) {
            return true;
        }
        return false;
    }

    public void validateInputWinningLotto(String inputWinningNumbers) {
        if (isNumberOrSeparator(inputWinningNumbers)) {
            return;
        }
        throw new IllegalArgumentException(InputMessage.ERROR_MESSAGE.getMessage());
    }

    public boolean isNumberOrSeparator(String inputWinningNumbers) {
        for (int index = EtcNumber.ZERO.getNumber(); index < inputWinningNumbers.length(); index++) {
            char number = inputWinningNumbers.charAt(index);
            if (!Character.isDigit(number) && number != ',') {
                return false;
            }
        }

        return true;
    }

    public void validateNumberRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(InputMessage.ERROR_MESSAGE.getMessage());
            }
        }
    }

    void validateInputBonusNumber(String inputBonusNumber) {
        if (isNumber(inputBonusNumber) && isRangeRight(inputBonusNumber)) {
            return;
        }
        throw new IllegalArgumentException(InputMessage.ERROR_MESSAGE.getMessage());
    }

    public boolean isRangeRight(String inputBonusNumber) {
        int number = Integer.parseInt(inputBonusNumber);
        if (number >= 1 && number <= 45) {
            return true;
        }

        return false;
    }
}
