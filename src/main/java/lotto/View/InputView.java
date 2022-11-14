package lotto.View;

import lotto.Dto.Lotto;
import lotto.Dto.Money;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Dto.ConstDto.InputOutputConstDto.*;

public class InputView {

    public Money printLotoBuyMoney(){
        System.out.println(BUY_LOTTO_MESSAGE);
        Money money = new Money(readLine());
        System.out.println();
        return money;
    }

    public Lotto printWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
        Lotto winningNumbers = new Lotto(readLine());
        System.out.println();
        return winningNumbers;
    }

    public void printbonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
