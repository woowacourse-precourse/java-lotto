package lotto;

import Game.Controller;
import OutputView.Print;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Print.purchasedMsg();
        Controller.run(Console.readLine());
    }
}
