package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class LottoDrawing {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;

    public void getWinningNumber() {
        System.out.println(MESSAGE_INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();

        List<Integer> winningNumbers = changeStringToNumberList(winningNumber);
        Lotto winningLotto = new Lotto(winningNumbers);
        this.winningNumbers = winningLotto.getNumbers();
    }

    private List<Integer> changeStringToNumberList(String input) {
        String[] tempInputs = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : tempInputs) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public void getBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }
}
