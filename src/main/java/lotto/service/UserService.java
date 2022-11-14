package lotto.service;

import lotto.domain.User;
import lotto.domain.enums.Message;
import lotto.domain.enums.Number;
import lotto.util.ExceptionHandler;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

public class UserService {

    public void calculateYield(User user) {
        double yield = user.getWinningAmount() / user.getMoney();
        yield *= Number.THOUSAND.getValue();
        yield = Math.round(yield);
        yield /= Number.TEN.getValue();
        user.setYield(yield);
    }

    public void updateRankAndWinningAmount(User user, int rank) {
        if (rank == Number.FIVE.getValue()) {
            user.setRankFifth();
        }
        if (rank == Number.FOUR.getValue()) {
            user.setRankFourth();
        }
        if (rank == Number.THREE.getValue()) {
            user.setRankThird();
        }
        if (rank == Number.TWO.getValue()) {
            user.setRankSecond();
        }
        if (rank == Number.ONE.getValue()) {
            user.setRankFirst();
        }
    }

    public void setInputMoney(User user) throws IllegalArgumentException {
        OutputUtil.printInputPurchaseAmount();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationMoney(input);
            double money = Double.parseDouble(input);
            user.setMoney(money);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputWinningNumbersError();
            throw illegalArgumentException;
        }
    }
}
