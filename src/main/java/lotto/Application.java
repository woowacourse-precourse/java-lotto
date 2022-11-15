package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Code.PrintCode.*;

public class Application {
    public static void main(String[] args) {

        System.out.println(GET_MONEY);
        int payedMoney = getSingleInput();


    }

    public static int getSingleInput() {
        String userAnswer = Console.readLine();
        return Integer.parseInt(userAnswer);
    }
}
