package system.process;

import constants.LottoConstant;
import models.WinningLotto;
import system.process.exception.IllegalArgument;
import utils.Input;
import utils.IsCollection;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoRegister {

    private WinningLotto winningLotto;

    public WinningLottoRegister() {
        List<Integer> sixLottoNumbers = changeLottoNumbersInputToIntegers(inputSixLottoNumbers());
        int bonusNumber = changeBonusNumberInputToInteger(inputBonusNumber());
        this.winningLotto = new WinningLotto(sixLottoNumbers, bonusNumber);
    }

    private String inputSixLottoNumbers() {
        printInputNumbers();

        String inputNumbers = Input.input();

        if(inputNumbers.length() > LottoConstant.MAX_WINNING_LOTTO_NUMBERS_LENGTH){
            IllegalArgument.handleException(IllegalArgument.OUT_OF_NUMBERS_LENGTH.getMessage());
        }

        return inputNumbers;
    }

    private List<Integer> changeLottoNumbersInputToIntegers(String numbersInput) {
        List<Integer> numbers = new ArrayList<>();

        for (int loop = 0; loop < 5; loop++) {
            int commaIndex = numbersInput.indexOf(",");

            validateCommaIndex(numbersInput, commaIndex);

            numbers.add(Integer.parseInt(numbersInput.substring(0, commaIndex)));
            numbersInput = numbersInput.substring(commaIndex + 1);
        }
        validateLastNumber(numbersInput);
        numbers.add(Integer.parseInt(numbersInput));

        return numbers;
    }

    private void validateCommaIndex(String numbersInput, int commaIndex) {
        if (commaIndex < LottoConstant.LEAST_COMMA_POSITION) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }
        if (Character.isDigit(numbersInput.charAt(commaIndex - 1))) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
    }

    private void validateLastNumber(String numberInput) {
        if (numberInput.isEmpty()) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }

        if (IsCollection.isDigitText(numberInput)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());

    }

    private String inputBonusNumber() {
        printInputBonusNumberText();

        String inputNumber = Input.input();

        if(inputNumber.length() > LottoConstant.MAX_WINNING_LOTTO_BONUS_NUMBERS_LENGTH){
            IllegalArgument.handleException(IllegalArgument.OUT_OF_BONUS_NUMBER_LENGTH.getMessage());
        }

        return inputNumber;
    }

    private int changeBonusNumberInputToInteger(String numberInput) {
        validateDigit(numberInput);

        int number = Integer.parseInt(numberInput);
        return number;
    }

    private void validateDigit(String numberInput) {
        if (numberInput.contains(",")) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    private void printInputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printInputBonusNumberText() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
