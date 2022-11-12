package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class LottoDrawing {
    List<Integer> winningNumbers = new ArrayList<>();
    Lotto winningLotto;
    int bonusNumber;
    public void getWinningNumber(){
        System.out.println(MESSAGE_INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        String[] winningNumbers = winningNumber.split(",");
        for(String number: winningNumbers){
            this.winningNumbers.add(Integer.parseInt(number));
        }
        winningLotto = new Lotto(this.winningNumbers);
    }
    public void getBonusNumber(){
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        bonusNumber = Integer.parseInt(Console.readLine());
    }
}
