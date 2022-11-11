package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;

public class WinningNumber {

    Lotto lotto;
    int bonusNumber;

    public WinningNumber() {
        inputWinningNumber();
        inputBonusNumber();
    }

    private void inputWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();

        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        String[] inputList = input.split(",");

        Validator.validateForIllegalInput(inputList);

        for (int i = 0; i < inputList.length; i++) {
            int num = Integer.parseInt(inputList[i]);
            winningNumber.add(num);
        }
        Validator.validateForRange(winningNumber);
        lotto = new Lotto(winningNumber);
        System.out.println();
    }

    private void inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        Validator.validateForIllegalInput(input);

        int bonus = Integer.parseInt(input);
        Validator.validateForDuplicatedNumber(lotto, bonus);

        bonusNumber = bonus;
        System.out.println();
    }


}
