package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public void run() {
        User user = getUserByInput();
        if (user == null) return;
        View.printPurchaseList(user.purchaseLottoList);

        Lotto lotto = getLottoByInput();
        if (lotto == null) return;

        int bonus = getBonusByInput();
        if(bonus == -1) return;

        try {
            validBonus(lotto, bonus);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        printResult(user, lotto, bonus);
    }

    private void printResult(User user, Lotto lotto, int bonus) {
        user.winResult = lotto.getWinningResult(user.purchaseLottoList, new Input(bonus));
        View.printWinningStatistics(user.winResult);
        View.printEarningsRate(Calculator.getEarningsRate(user.inputCost, user.winResult));
    }

    private void validBonus(Lotto lotto, int bonus) {
        try {
            lotto.bonusNotIncludeWinningNumbers(bonus);
        } catch (Exception e) {
            throw e;
        }
    }


    private User getUserByInput() {
        View.printStartMessage();
        User user;
        try {
            user = new User(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        user.getPurchaseLottoList();
        return user;
    }

    private int getBonusByInput() {
        View.printNeedBonusNumber();
        int result;
        try {
            result = Input.getInputToInt(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return result;
    }

    private Lotto getLottoByInput() {
        View.printNeedWinningNumbers();
        Lotto lotto;
        try {
            lotto = new Lotto(Input.getWinningNumber(readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return lotto;
    }


}
