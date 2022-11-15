package lotto.service;

import lotto.domain.enums.Rank;
import lotto.domain.User;
import lotto.domain.constant.ConstantValue;
import lotto.util.ExceptionHandler;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

public class UserService {

    public void calculateYield(User user) {
        double yield = user.getTotalPrize() / user.getMoney();
        yield *= ConstantValue.THOUSAND;
        yield = Math.round(yield);
        yield /= ConstantValue.TEN;
        user.setYield(yield);
    }

    public void updateRankAndTotalPrize(User user, Rank rank) {
        if (rank == Rank.FIFTH) {
            user.setRankFifth();
        }
        if (rank == Rank.FOURTH) {
            user.setRankFourth();
        }
        if (rank == Rank.THIRD) {
            user.setRankThird();
        }
        if (rank == Rank.SECOND) {
            user.setRankSecond();
        }
        if (rank == Rank.FIRST) {
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
