package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        Controller controller = new Controller();
        int money = console.inputMoney();
        int count = controller.getCount(money);
        List<Lotto> issuedList = controller.issueLotto(count);
        List<Integer> numbers = console.inputWinningNumber();
        Lotto winningLotto = controller.issueWinningNumber(numbers);
        int number = console.inputPlusNumber();
        winningLotto.checkPlusNumber(number);

    }
}
