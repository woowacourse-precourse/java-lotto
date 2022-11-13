package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();
        List<Integer> winningNumber = new ArrayList<>();

        int money = user.inputMoneyMsg();
        int amount = user.moneyToAmount(money);
        user.setLottoList(computer.issuedLotto(amount));

        winningNumber = computer.inputWinningNumber();
        Lotto lotto = new Lotto(winningNumber);

    }
}
