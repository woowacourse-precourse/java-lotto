package system.process;

import models.WinningLotto;
import system.process.exception.IllegalArgument;
import utils.Input;
import utils.IsCollection;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoRegister {

    private WinningLotto winningLotto;

    public WinningLottoRegister() {
        this.winningLotto = new WinningLotto(inputSixLottoNumbers(), inputBonusNumber());
    }

    private List<Integer> inputSixLottoNumbers() {

        printInputNumbers();

        String numbersInput = Input.input();
        List<Integer> numbers = new ArrayList<>();

        // ,,,, ,,1,,2,,3,4,6
        for (int loop = 0; loop < 5; loop++) {
            int commaIndex = numbersInput.indexOf(",");

            //처음 부터 쉼표가 나오면 안된다(0이 나온 경우). 못 찾는 경우도 안된다.(-1이 나온 경우)
            if (commaIndex < 1) {
                IllegalArgument.handleException(IllegalArgument.WRONG_COMMA.getMessage());
            }

            //쉼표의 위치에서 바로 전 위치에는 무조건 숫자가 있어야만 한다.
            if (!Character.isDigit(numbersInput.charAt(commaIndex - 1))) {
                IllegalArgument.handleException(IllegalArgument.WRONG_COMMA.getMessage());
            }

            numbers.add(Integer.parseInt(numbersInput.substring(0, commaIndex)));
            numbersInput = numbersInput.substring(commaIndex + 1);
        }
        numbers.add(Integer.parseInt(numbersInput));

        return numbers;
    }

    private void printInputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

    }

    private int inputBonusNumber() {
        printInputBonusNumberText();

        String numberInput = Input.input();

        if (IsCollection.isContain(numberInput,",")) {
            throw new IllegalArgumentException("[ERROR] 올바르게 보너스 번호를 입력해주세요.");
        }

        int number = Integer.parseInt(numberInput);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 범위가 1~45의 숫자가 아닙니다.");
        }
        return number;

    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    private void printInputBonusNumberText(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
