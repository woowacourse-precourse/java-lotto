package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class LottoDrawing {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;
    public List<Integer> getWinningNumber(){
        System.out.println(MESSAGE_INPUT_WINNING_NUMBER);

        String winningNumberInput = Console.readLine();
        String[] WinningNumberInputs = winningNumberInput.split(",");
        List<Integer> tempNumbers = new ArrayList<>();
        for(String number: WinningNumberInputs){
            tempNumbers.add(Integer.parseInt(number));
        }

        Lotto winningLotto = new Lotto(tempNumbers);
        winningNumbers = winningLotto.getNumbers();

        return winningLotto.getNumbers();
    }

    public int getBonusNumber(){
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }
}
