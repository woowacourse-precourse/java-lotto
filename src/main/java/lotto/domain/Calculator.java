package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 입력받은 번호 가져오기
    public static void getInputNumbers() {
        List<Integer> winningNumbers = inputWinningNumber();
        Integer bonusNumber = inputBonusNumber();
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

    // 당첨 번호와 발행 로또 번호 비교

    // 보너스 번호와 발행 로또 번호 비교

}
