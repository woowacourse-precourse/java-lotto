package system.process;

import models.WinningLotto;
import system.process.validation.WinningLottoRegisterValidation;
import utils.Input;
import veiw.WinningLottoRegisterView;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoRegister {
    private WinningLotto winningLotto;

    public WinningLottoRegister() {
        List<Integer> sixLottoNumbers = changeLottoNumbersInputToIntegers(inputSixLottoNumbers());
        int bonusNumber = changeBonusNumberInputToInteger(inputBonusNumber());
        winningLotto = new WinningLotto(sixLottoNumbers, bonusNumber);
    }

    private String inputSixLottoNumbers() {
        WinningLottoRegisterView.printInputNumbers();

        String inputNumbers = Input.input();
        WinningLottoRegisterValidation.validateLottoNumbersInput(inputNumbers);

        return inputNumbers;
    }


    private List<Integer> changeLottoNumbersInputToIntegers(String numbersInput) {
        List<Integer> numbers = new ArrayList<>();

        for (int loop = 0; loop < 5; loop++) {
            int commaIndex = numbersInput.indexOf(",");

            WinningLottoRegisterValidation.validateCommaIndex(numbersInput, commaIndex);

            numbers.add(Integer.parseInt(numbersInput.substring(0, commaIndex)));
            numbersInput = numbersInput.substring(commaIndex + 1);
        }
        WinningLottoRegisterValidation.validateLastNumber(numbersInput);
        numbers.add(Integer.parseInt(numbersInput));

        return numbers;
    }

    private String inputBonusNumber() {
        WinningLottoRegisterView.printInputBonusNumberText();

        String inputNumber = Input.input();
        WinningLottoRegisterValidation.validateBonusNumberInput(inputNumber);

        return inputNumber;
    }

    private int changeBonusNumberInputToInteger(String numberInput) {
        WinningLottoRegisterValidation.validateDigit(numberInput);

        int number = Integer.parseInt(numberInput);
        return number;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
