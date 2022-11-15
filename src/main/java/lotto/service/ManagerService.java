package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Manager;
import lotto.domain.User;
import lotto.domain.constant.ConstantValue;
import lotto.util.ExceptionHandler;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;
import java.util.ArrayList;
import java.util.List;

public class ManagerService {

    UserService userService = new UserService();
    LottoMachine lottoMachine = new LottoMachine();

    public void changeToLottos(User user) {
        List<Lotto> lottos = new ArrayList<>();
        int totalCount = (int)user.getMoney() / ConstantValue.THOUSAND;

        for (int repeat = 1; repeat <= totalCount; repeat++) {
            Lotto lotto = lottoMachine.generateLotto();
            lottos.add(lotto);
        }
        user.setLottos(lottos);
    }

    public void setWinningNumber(Manager manager) throws IllegalArgumentException {
        OutputUtil.printInputWinningNumbers();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationWinningNumber(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputWinningNumbersError();
            throw illegalArgumentException;
        }
        manager.setWinningNumbers(input);
    }

    public void setBonusNumber(Manager manager) throws IllegalArgumentException {
        OutputUtil.printInputBonusNumber();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationBonusNumber(input, manager.getWinningNumbers());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputBonusNumberError();
            throw illegalArgumentException;
        }
        manager.setBonusNumber(input);
    }

    public void judgeResult(User user, Manager manager) {
        List<Lotto> userLottos = user.getLottos();
        for (Lotto userLotto : userLottos) {
            int correctCount = manager.countCorrect(userLotto);
            boolean isCorrectBonus = manager.isCorrectBonus(userLotto);
            int rank = judgeRank(correctCount, isCorrectBonus);
            userService.updateRankAndTotalPrize(user, rank);
        }
    }

    public int judgeRank(int correctCount, boolean isCorrectBonus) {
        if (correctCount == ConstantValue.THREE) {
            return ConstantValue.FIVE;
        }
        if (correctCount == ConstantValue.FOUR) {
            return ConstantValue.FOUR;
        }
        if (correctCount == ConstantValue.FIVE) {
            if (isCorrectBonus) {
                return ConstantValue.TWO;
            }
            return ConstantValue.THREE;
        }
        if (correctCount == ConstantValue.SIX) {
            return ConstantValue.ONE;
        }
        return ConstantValue.ZERO;
    }

}
