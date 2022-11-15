package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Code.ErrorCode.*;
import static lotto.Code.PrintCode.*;

public class Application {
    public static void main(String[] args) {

        System.out.println(GET_MONEY);
        int payedMoney = getSingleInput();
        checkMoneyCanDivideBy1000(payedMoney);

        int lottoCount = payedMoney/1000;
        System.out.println("\n" + lottoCount + PRINT_LOTTO_COUNT);

    }

    public static int getSingleInput() {
        String userAnswer = Console.readLine();
        return Integer.parseInt(userAnswer);
    }
    public static void checkMoneyCanDivideBy1000(int money){
        if (money/1000 != 0)
            throw new IllegalArgumentException(String.valueOf(NO_DIVIDE_BY_1000));
    }



}
