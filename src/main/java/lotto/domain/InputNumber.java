package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    // 입력받은 번호 가져오기
    public static List<Object> getInputNumbers() {
        List<Integer> winningNumbers = inputWinningNumber();
        Integer bonusNumber = inputBonusNumber();

        List<Object> inputNumbers = List.of(winningNumbers, bonusNumber);
        return inputNumbers;
    }

    public static List<Integer> inputWinningNumber() {
        LottoView.inputLottoNumber();
        String inputNumber = Console.readLine();

        List<String> splitedInputNumber = List.of(inputNumber.split(","));
        List<Integer> inputLottos = new ArrayList<>();
        for (String number : splitedInputNumber) {
            Validator.checkOnlyNumber(number);
            inputLottos.add(Integer.valueOf(number));
        }

        Lotto lotto = new Lotto(inputLottos);
        List<Integer> winningNumbers = lotto.getNumbers();

        return winningNumbers;
    }

    public static int inputBonusNumber() {
        LottoView.inputBonusNumber();
        String inputNumber = Console.readLine();

        return Validator.validateBonus(inputNumber);
    }

}
