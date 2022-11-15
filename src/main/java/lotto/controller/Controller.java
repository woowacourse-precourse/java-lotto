package lotto.controller;

import lotto.view.View;
import lotto.logic.Calculator;
import lotto.domain.Lotto;
import lotto.logic.LottoVerifier;
import lotto.domain.User;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public void run() {
        User user = getUserByInput();
        if (user == null) return;

        getAndPrintPurchaseNumbers(user);

        Lotto lotto = getLottoByInput();
        if (lotto == null) return;

        int bonus = getBonusByInput();
        if (bonus == -1) return;


        if (isValidInputBonus(lotto, bonus)) return;
        printResult(user, lotto, bonus);
    }

    private boolean isValidInputBonus(Lotto lotto, int bonus) {
        try {
            lotto.bonusNotIncludeWinningNumbers(bonus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private void printResult(User user, Lotto lotto, int bonus) {
        user.winResult = lotto.getWinningResult(user.purchaseNumbers, new LottoVerifier(bonus));
        View.printWinningStatistics(user.winResult);
        View.printEarningsRate(Calculator.getEarningsRate(user.inputCost, user.winResult));
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

        return user;
    }

    private void getAndPrintPurchaseNumbers(User user) {
        user.getPurchaseNumbers();
        View.printPurchaseList(user.purchaseNumbers);
    }

    private int getBonusByInput() {
        View.printNeedBonusNumber();
        int result;
        try {
            result = LottoVerifier.getInputToInt(readLine());
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
            lotto = new Lotto(LottoVerifier.getWinningNumber(readLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return lotto;
    }


}
