package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Manager;
import lotto.domain.User;
import lotto.domain.constant.ConstantValue;
import lotto.domain.enums.Rank;
import lotto.util.ExceptionHandler;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
            Rank rank = judgeRank(correctCount, isCorrectBonus);
            userService.updateRankAndTotalPrize(user, rank);
        }
    }

    public Rank judgeRank(int correctCount, boolean isCorrectBonus) {
        if (correctCount <= 2) {
            return Rank.MISS;
        }

        Rank[] rankValues = Rank.values();
        Rank result = Arrays.stream(rankValues)
                .filter(rank -> rank.getCorrectCount() == correctCount)
                .findFirst()
                .get();

        if (result == Rank.THIRD && isCorrectBonus) {
            return Rank.SECOND;
        }
        return result;
    }

}
