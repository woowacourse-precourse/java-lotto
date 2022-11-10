package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int money;
        List<Integer> winningNumbers;
        int bonusNumber;
        Lotto winningLotto;
        User user;

        money = Converter.convertMoneyInput(readLine());
        user = new User(money);
        user.printLottos();

        winningNumbers = Converter.convertNumbersInput(readLine());
        winningLotto = new Lotto(winningNumbers);

        bonusNumber = Converter.convertBonusNumberInput(readLine());
        Lotto.setBonusNumber(bonusNumber);

    }
}
