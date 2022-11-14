package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Manager;
import lotto.domain.User;
import lotto.domain.enums.Number;
import lotto.util.ExceptionHandler;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;
import java.util.ArrayList;
import java.util.List;

public class ManagerService {

    UserService userService = new UserService();
    LottoMachine lottoMachine = new LottoMachine();

    public void changeLottos(User user) {
        List<Lotto> lottos = new ArrayList<>();
        int totalCount = (int)user.getMoney() / 1000;

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
            manager.setWinningNumbers(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputWinningNumbersError();
            throw illegalArgumentException;
        }
    }

    public void setBonusNumber(Manager manager) throws IllegalArgumentException {
        OutputUtil.printInputBonusNumber();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationBonusNumber(input, manager.getWinningNumbers());
            manager.setBonusNumber(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputBonusNumberError();
            throw illegalArgumentException;
        }
    }

    public void judgeResult(User user, Manager manager) {
        List<Lotto> userLottos = user.getLottos();
        for (Lotto userLotto : userLottos) {
            int correctCount = manager.countCorrect(userLotto);
            boolean isCorrectBonus = manager.isCorrectBonus(userLotto);
            int rank = judgeRank(correctCount, isCorrectBonus);
            userService.updateRankAndWinningAmount(user, rank);
        }
    }

    public int judgeRank(int correctCount, boolean isCorrectBonus) {
        if (correctCount == Number.THREE.getValue()) {
            return Number.FIVE.getValue();
        }
        if (correctCount == Number.FOUR.getValue()) {
            return Number.FOUR.getValue();
        }
        if (!isCorrectBonus && correctCount == Number.FIVE.getValue()) {
            return Number.THREE.getValue();
        }
        if (isCorrectBonus && correctCount == Number.FIVE.getValue()) {
            return Number.TWO.getValue();
        }
        if (correctCount == Number.SIX.getValue()) {
            return Number.ONE.getValue();
        }
        return Number.ZERO.getValue();
    }


}
