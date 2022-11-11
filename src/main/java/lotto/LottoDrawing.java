package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoDrawing {
    List<Integer> winningNumber;
    Lotto winningLotto;

    public void getWinningNumber(){
        String winningNumber = Console.readLine();
        String[] winningNumbers = winningNumber.split(",");
        for(String number: winningNumbers){
            this.winningNumber.add(Integer.parseInt(number));
        }
        winningLotto = new Lotto(this.winningNumber);
    }
}
