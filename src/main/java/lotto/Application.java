package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        run();


    }

    private static void run() {
        View view = new View();
        view.printStartMessage();
        User user;
        try {
            user = new User(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        user.getPurchaseLottoList();
        view.printPurchaseList(user.purchaseLottoList);

        view.printNeedWinningNumbers();
        Lotto lotto;
        try {
            lotto = new Lotto(Input.getWinningNumber(readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        view.printNeedBonusNumber();
        int bonus;
        try {
            bonus = Input.getInputToInt(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


        lotto.bonusNotIncludeWinningNumbers(bonus);
        Input input = new Input(bonus);

        user.winningArray = lotto.getWinningArray(user.purchaseLottoList, input);

        view.printWinningStatistics(user.winningArray);

        Calculator calculator = new Calculator();
        view.printEarningsRate(calculator.getEarningsRate(user.inputCost, user.winningArray));
    }


}
