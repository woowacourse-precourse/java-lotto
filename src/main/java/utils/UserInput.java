package utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.Count;
import lotto.LottoNumber;

import static constant.Messages.*;

public class UserInput {

    public static Count inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String price = Console.readLine();
        return new Count(price);
    }

    public static LottoNumber inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
        String winningNumbers = Console.readLine();

        System.out.println(INPUT_BONUS_NUM_MESSAGE);
        String bonusNumber = Console.readLine();
        return new LottoNumber(winningNumbers, bonusNumber);
    }
}
