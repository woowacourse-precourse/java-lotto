package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int Money = 50000; //user 의 잔고
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //user의 lotto 구매
        User user = new User(Money);
        user.buyLotto();

        //당첨 번호 입력
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.inputNumber();

        user.printLotto();
        user.checkWinning(winningNumber);
        user.computeProfit();


    }
}
