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
        yield *= Number.THOUSAND;
        yield = Math.round(yield);
        yield /= Number.TEN;
        user.setYield(yield);
    }

    public void updateRankAndWinningAmount(User user, int rank) {
        if (rank == Number.FIVE) {
            user.setRankFifth();
        }
        if (rank == Number.FOUR) {
            user.setRankFourth();
        }
        if (rank == Number.THREE) {
            user.setRankThird();
        }
        if (rank == Number.TWO) {
            user.setRankSecond();
        }
        if (rank == Number.ONE) {
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
