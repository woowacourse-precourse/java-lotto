package View;

import Dto.Money;

import static Dto.ConstDto.InputOutputConstDto.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Money printLotoBuyMoney(){
        System.out.println(BUY_LOTTO_MESSAGE);
        Money money = new Money(readLine());
        return money;
    }

    public void printWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public void printbonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
