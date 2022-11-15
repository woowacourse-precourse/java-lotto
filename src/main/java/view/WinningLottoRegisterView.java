package view;

import view.validation.WinningLottoRegisterViewValidation;
import utils.Input;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoRegisterView {
    public static List<Integer> inputWinningLottoNumbers(){
        String LottoNumbersInput = inputLottoNumbers();
        return changeLottoNumbersInputToIntegers(LottoNumbersInput);
    }
    private static String inputLottoNumbers() {
        WinningLottoRegisterView.printInputNumbersText();

        String numbersInput = Input.input();
        WinningLottoRegisterViewValidation.validateLottoNumbersInput(numbersInput);

        return numbersInput;
    }

    private static List<Integer> changeLottoNumbersInputToIntegers(String numbersInput) {
        List<Integer> numbers = new ArrayList<>();

        for (int loop = 0; loop < 5; loop++) {
            int commaIndex = numbersInput.indexOf(",");
            WinningLottoRegisterViewValidation.validateCommaIndex(numbersInput, commaIndex);

            numbers.add(Integer.parseInt(numbersInput.substring(0, commaIndex)));
            numbersInput = numbersInput.substring(commaIndex + 1);
        }
        WinningLottoRegisterViewValidation.validateLastNumber(numbersInput);
        numbers.add(Integer.parseInt(numbersInput));

        return numbers;
    }

    public static int inputWinningLottoBonusNumber(){
        String bonusNumberInput = inputBonusNumber();
        return Integer.parseInt(bonusNumberInput);
    }

    private static String inputBonusNumber() {
        WinningLottoRegisterView.printInputBonusNumberText();

        String numberInput = Input.input();
        WinningLottoRegisterViewValidation.validateBonusNumberInput(numberInput);

        return numberInput;
    }

    public static void printInputNumbersText() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumberText() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
