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
        this.winningLotto = new WinningLotto(
                changeLottoNumbersInputToIntegers(inputSixLottoNumbers())
                , changeBonusNumberInputToInteger(inputBonusNumber()));
    }

    private String inputSixLottoNumbers() {
        printInputNumbers();
        return Input.input();
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
        if (commaIndex < LottoConstant.LEAST_COMMA_POS
                || !Character.isDigit(numbersInput.charAt(commaIndex - 1))) { // 여기 다시 고민해볼 것.
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }
    }

    private void validateLastNumber(String numbersInput) {
        if (numbersInput.isEmpty()) {
            IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS_INPUT.getMessage());
        }
    }

    private String inputBonusNumber() {
        printInputBonusNumberText();
        return Input.input();
    }

    private int changeBonusNumberInputToInteger(String numberInput) {
        validateDigit(numberInput);

        int number = Integer.parseInt(numberInput);
        return number;
    }

    private void validateDigit(String numberInput) {
        if (IsCollection.isContainText(numberInput, ",")) {
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
