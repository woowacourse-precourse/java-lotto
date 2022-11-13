package View;

import static ConstDto.InputOutputConstDto.BUY_LOTTO_MESSAGE;
import static ConstDto.InputOutputConstDto.INPUT_WINNING_NUMBERS;

public class InputView {

    public void printLotoBuyMoney(){
        System.out.println(BUY_LOTTO_MESSAGE);
    }

    public void printWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }
}
