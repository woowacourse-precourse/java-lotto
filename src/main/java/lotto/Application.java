package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            lottoGameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    static void lottoGameStart() {
        View view = new View();
        view.printSpentMoneyMenu();
        String playerNum = Console.readLine();
    }
}
